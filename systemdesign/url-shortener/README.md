# URL Shortener

## Intuition
A URL shortener maps a long URL to a short identifier and redirects users to the original URL.
The system behaves conceptually like a distributed key-value store and is optimized for
read-heavy traffic patterns.

---

## Why This System Is Asked in Interviews
- Tests understanding of **read-heavy system design**
- Evaluates tradeoffs between **ID generation vs hashing**
- Surfaces knowledge of **caching, hot keys, and latency**
- Simple product with non-trivial scaling challenges

---

## Core Functional Requirements
- Generate a unique short URL for a given long URL
- Redirect users with low latency
- Support very high read throughput
- Ensure correctness (no wrong redirects)

---

## Write Path (URL Creation)
1. User submits a long URL
2. System generates a unique numeric ID
3. ID is encoded using Base62 to form the short code
4. Mapping is stored in the database
5. Shortened URL is returned to the user

**Why this works**
- ID-based generation avoids collisions
- Base62 keeps URLs short and human-friendly
- Write throughput is manageable since reads dominate

---

## Read Path (Redirect Flow)
1. User hits the short URL
2. Load balancer routes request to app server
3. App checks cache for `short_code → long_url`
4. On cache hit: immediately redirect (HTTP 302)
5. On cache miss: fetch from DB, populate cache, redirect

This ensures low latency and protects the database from hot keys.

---

## Data Model

| Field       | Description |
|------------|-------------|
| id         | Auto-increment primary key |
| short_code | Base62-encoded ID |
| long_url   | Original URL |
| created_at | Creation timestamp |
| expires_at | Optional expiration |

The short code can be derived from the ID but may be stored to simplify reads.

---

## Caching Strategy
- Cache type: In-memory distributed cache (e.g., Redis)
- Key: `short_code`
- Value: `long_url`
- Pattern: Cache-aside (lazy loading)

**Why caching is critical**
- 90%+ of traffic is reads
- Hot URLs are accessed repeatedly
- Memory lookups are significantly faster than DB queries

---

## Tradeoffs & Design Decisions
- **ID-based generation vs hashing**: avoids collisions and retry logic
- **Cache-aside vs write-through**: simpler and sufficient for read-heavy access
- **Storing short_code vs deriving**: storage vs simplicity tradeoff

---

## Edge Cases (Not Fully Explored Yet)
- Cache failure fallback to DB
- URL expiration and cleanup
- Handling extremely hot keys

---

## Progress Log
- Day 1: Understood core read/write flow and caching intuition
- Day 2: Added ID generation, Base62 encoding, and interview-level tradeoffs