# Scenario-Based Design Questions – URL Shortener

This document contains common interview and production scenarios,
with reasoning and tradeoffs for each.

---

## 1. Hot Key Problem

This scenario explores how a single popular key can become a bottleneck
even when the rest of the system scales horizontally.

### Scenario
One short URL becomes extremely popular and receives 10M QPS.

### Problem
- Single Redis key becomes bottleneck
- App servers scaling does not help

### Reasoning
- Bottleneck is at cache layer, not app layer

### Solutions
- Local in-memory cache in app servers
- Push hot URLs to CDN / edge cache

### Tradeoffs
- Memory duplication across app servers
- Stale data risk vs performance

---

## 2. Cache Update Failure

### Scenario
DB write succeeds, cache update fails, immediate read arrives.

### Outcome
- Cache returns stale mapping

### Acceptability
- Eventual consistency is acceptable for URL shortener because mappings rarely change
- Mappings rarely change

### Tradeoff
- Strong consistency increases latency and complexity

---

## 3. ID Generation with Multiple Writers

### Scenario
Multiple app servers generate short URLs concurrently.
We need globally unique IDs with high throughput and no single bottleneck.

### Naive Approach
Using auto-increment in a single database does not scale:
- Single writer bottleneck
- Hard to scale across machines

---

### Option 1: Central ID Service

A single service generates incremental IDs.

Pros:
- Simple
- Strong consistency

Cons:
- Single point of failure
- Throughput bottleneck

Used only for small-scale systems.

---

### Option 2: Pre-Allocate ID Ranges (Chosen)

Database allocates ID ranges to each server:

- Server A: 1–1M  
- Server B: 1M–2M  

Each server generates IDs locally.

Pros:
- No coordination per request
- Very high throughput
- Simple design

Cons:
- Wasted IDs if server crashes
- Gaps in ID sequence

This is a good tradeoff for medium to large-scale systems.

---

### Option 3: Time-Based Distributed IDs

IDs are constructed from:
- Timestamp
- Machine ID
- Local sequence

Pros:
- Fully distributed
- No bottleneck
- Scales well

Cons:
- Complex
- Clock synchronization issues

Used in very large-scale systems.

## Progress Log
- Day 3: Explored scenario based questions and reasoning