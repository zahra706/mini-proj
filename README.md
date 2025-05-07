# 📚 Mini-Projet : Application Web Formations en ligne – Partie 2

## 🎯 Objectifs

Ce projet a pour but de développer une application web de formations en ligne en suivant une architecture microservices, intégrant une base de données NoSQL (MongoDB), SQL (PostgreSQL), du caching avec Redis, et des fonctionnalités IA (résumé automatique, recommandations de livres).

---

## ⚙️ Architecture du Projet

📦 mini-projet/
├── favorite-service/ # Microservice favoris (Spring Boot + MongoDB + Redis)
│ ├── src/
│ └── pom.xml
│
├── recommendation-api/ # API FastAPI pour scraping + résumé + recommandations
│ ├── app/
│ └── requirements.txt
│
├── frontend/ # Frontend React / Angular / Next.js
│ └── ... (favoris, résumé, affichage recommandations)
│
├── tests/
│ ├── unit/ # JUnit, Mockito, Pytest
│ ├── integration/
│ └── e2e/ # Selenium / Cypress
│
├── README.md
└── .gitignore

yaml
Copier
Modifier

---

## 🛠️ Technologies utilisées

| Backend (Favoris) | Backend (Livres & IA) | Frontend     | DB               | Cache  | IA / NLP     | Tests                   |
|-------------------|------------------------|--------------|------------------|--------|--------------|--------------------------|
| Spring Boot       | FastAPI                | React / Next | MongoDB, Postgre | Redis  | OpenAI / LLM | JUnit, Mockito, Selenium |

---

## 🔐 Fonctionnalités

### 🎯 1. Microservice Favoris (Spring Boot + MongoDB + Redis)

- Ajouter un favori
- Supprimer un favori
- Récupérer tous les favoris d’un utilisateur
- Base MongoDB
- Cache Redis pour lecture rapide

### 🔎 2. Recommandations de livres (FastAPI + PostgreSQL)

- Scraping depuis [books.toscrape.com](https://books.toscrape.com)
- Stockage dans `recommended_books` (PostgreSQL)
- Affichage des livres avec filtres :
  - Catégorie : `?category=Travel`
  - Prix min/max : `?price_min=10&price_max=30`

### 🤖 3. Résumé intelligent

- Route : `/books/summary`
- Utilisation d’un LLM (OpenAI, HuggingFace, etc.)
- Génération automatique d’un résumé de livre

---

## 📌 API REST

### 📍 Microservice Favoris (Spring Boot)
| Méthode | Endpoint                    | Description                        |
|---------|-----------------------------|------------------------------------|
| GET     | `/api/favorites/{userId}`   | Récupérer favoris d’un utilisateur|
| POST    | `/api/favorites`            | Ajouter un favori                  |
| DELETE  | `/api/favorites/{id}`       | Supprimer un favori                |

### 📍 Recommandations (FastAPI)
| Méthode | Endpoint                      | Description                                 |
|---------|-------------------------------|---------------------------------------------|
| GET     | `/recommendations`            | Liste des livres (filtres supportés)        |
| GET     | `/books/summary?title=...`    | Générer un résumé intelligent               |
| GET     | `/scrape`                     | Scraper les livres depuis BooksToScrape     |

---

## 🚀 Instructions de déploiement

### 📦 Backend Spring Boot
```bash
cd favorite-service
./mvnw spring-boot:run
⚡ API FastAPI
bash
Copier
Modifier
cd recommendation-api
uvicorn app.main:app --reload
🖥️ Frontend
Lancer avec Vite / React / Angular :

bash
Copier
Modifier
npm install
npm run dev
✅ Tests
Unitaires : JUnit (Java), Pytest (Python)

Intégration : avec MongoDB / PostgreSQL

End-to-End (E2E) : Selenium ou Cypress

📌 Jira Scrum
2 Sprints de 1 semaine

User Stories :

Ajouter favoris

Supprimer favoris

Voir mes favoris

Scraper livres

Afficher recommandations

Résumé intelligent

Liens :

Board Jira

GitHub Repo

✍️ Auteur
👩‍💻 Zahra — Étudiante en informatique

📅 Projet académique 2025 – [Mini Projet Wahid Hamdi]
