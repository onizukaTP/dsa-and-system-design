# URL Shortener

## Intuition
- A URL shortener maps a long url to a short identifier
- Look up time O(1) short_code --> long_url
- Conceptually behaves like a hash map
- Optimized for read-heavy traffic

## Why it exists
- Long URLs are ugly
- Platform limit characters
- Tracking

## Core flow
- User hits short_code
- System looks up short_code
- Finds long_url
- Returns HTTP 302 redirect

## Write Path
- User submits long url
- System generated a short code
- System mapping in DB
- Returns shortened url

## Data Model
- short_code (PK)
- long_url
- created_at
- expires_at (nullable) (optional)

## Caching
- Cache short_code --> long_url
- Improves latency and reduces DB load

## What I'm confident about
- End to end flow
- Why Caching is critical
- Why short_code is the PK (Fast look up)

## What I'm parking for later
- ID Generation
- Distributed Scaling
- Analytics design

### Progress Log
- Day 1: Understood core read/write flow and caching intuition