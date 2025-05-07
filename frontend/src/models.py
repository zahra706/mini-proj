from sqlalchemy import Column, Integer, String, Float
from database import Base

class RecommendedBook(Base):
    __tablename__ = "recommended_books"
    id = Column(Integer, primary_key=True, index=True)
    title = Column(String, index=True)
    price = Column(Float)
    category = Column(String)
    availability = Column(String)