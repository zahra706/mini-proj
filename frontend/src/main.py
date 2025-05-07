from fastapi import FastAPI, Depends, Query
from sqlalchemy.orm import Session
from database import SessionLocal, Base
from models import RecommendedBook
from scraper import scrape_books
from llm import generate_summary

app = FastAPI()

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

@app.post("/scrape")
def scrape():
    scrape_books()
    return {"message": "Books scraped and stored"}

@app.get("/recommendations")
def get_recommendations(
    category: str = Query(None),
    price_min: float = Query(None),
    price_max: float = Query(None),
    db: Session = Depends(get_db)
):
    query = db.query(RecommendedBook)
    if category:
        query = query.filter(RecommendedBook.category == category)
    if price_min is not None:
        query = query.filter(RecommendedBook.price >= price_min)
    if price_max is not None:
        query = query.filter(RecommendedBook.price <= price_max)
    return query.all()

@app.get("/books/summary")
def get_book_summary(title: str):
    summary = generate_summary(title)
    return {"title": title, "summary": summary}