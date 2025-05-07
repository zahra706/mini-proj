import requests
from bs4 import BeautifulSoup
from database import SessionLocal, Base
from models import RecommendedBook

def scrape_books():
    url = "https://books.toscrape.com"
    response = requests.get(url)
    soup = BeautifulSoup(response.text, "html.parser")
    books = []
    for book in soup.select("article.product_pod"):
        title = book.h3.a["title"]
        price = float(book.select_one(".price_color").text.replace("£", ""))
        category = "Fiction"  # Simplified; extend with category scraping
        availability = book.select_one(".availability").text.strip()
        books.append({"title": title, "price": price, "category": category, "availability": availability})
    db = SessionLocal()
    Base.metadata.create_all(bind=db.get_bind())
    for book in books:
        db_book = RecommendedBook(**book)
        db.add(db_book)
    db.commit()
    db.close()