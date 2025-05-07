import React, { useState, useEffect } from 'react';
import axios from 'axios';
function Recommendations() {
    const [books, setBooks] = useState([]);
    const [category, setCategory] = useState('');
    const [priceMin, setPriceMin] = useState('');
    const [priceMax, setPriceMax] = useState('');
    const [title, setTitle] = useState('');
    const [summary, setSummary] = useState('');
    const fetchBooks = async () => {
        const params = { category, price_min: priceMin, price_max: priceMax };
        const response = await axios.get('http://localhost:8000/recommendations', { params });
        setBooks(response.data);
    };
    const fetchSummary = async () => {
        const response = await axios.get('http://localhost:8000/books/summary', { params: { title } });
        setSummary(response.data.summary);
    };
    useEffect(() => {
        fetchBooks();
    }, [category, priceMin, priceMax]);
    return (
        <div>
            <h2>Book Recommendations</h2>
            <input placeholder="Category" onChange={(e) => setCategory(e.target.value)} />
            <input placeholder="Min Price" onChange={(e) => setPriceMin(e.target.value)} />
            <input placeholder="Max Price" onChange={(e) => setPriceMax(e.target.value)} />
            <button onClick={fetchBooks}>Filter Books</button>
            <ul>
                {books.map((book) => (
                    <li key={book.id}>{book.title} - £{book.price}</li>
                ))}
            </ul>
            <h2>Book Summary</h2>
            <input placeholder="Book Title" onChange={(e) => setTitle(e.target.value)} />
            <button onClick={fetchSummary}>Get Summary</button>
            <p>{summary}</p>
        </div>
    );
}
export default Recommendations;