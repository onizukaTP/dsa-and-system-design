# Rate Limiter

## Intuition
A rate limiter controls how many requests a client can make within a given time window.
It protects systems from abuse, prevents overload, and ensures fair usage across clients.

At a high level, it sits in front of services and decides whether a request should be
**allowed or rejected** based on predefined limits.

---

## Why This System Is Asked in Interviews
- Tests understanding of **system protection and fairness**
- Evaluates knowledge of **state management at scale**
- Surfaces tradeoffs between **accuracy, performance, and complexity**
- Common real-world problem used across APIs and distributed systems

---

## Core Functional Requirements
- Limit the number of requests per client
- Enforce limits over a defined time window
- Make decisions with very low latency
- Work correctly under high concurrency

---

## Where a Rate Limiter Lives
A rate limiter can be placed:
- At the **API Gateway**
- At the **Load Balancer**
- Inside the **Application Layer**

Placing it closer to the edge reduces unnecessary load on downstream services.

---

## Basic Rate Limiting Approaches

### Fixed Window
- Count requests in a fixed time window (e.g., 100 requests per minute)
- Simple to implement
- Can allow bursts at window boundaries

### Sliding Window
- Smooths request count over time
- More accurate than fixed window
- Slightly more complex and state-heavy

### Token Bucket
- Tokens refill at a constant rate
- Requests consume tokens
- Allows controlled bursts while enforcing long-term limits

---

## State & Storage
- Rate limiting requires **shared state**
- State must be fast to read and update
- In-memory stores (like Redis) are commonly used

Typical stored data:
- Client identifier (IP, user ID, API key)
- Request count or token count
- Timestamp or last refill time

---

## High-Level Request Flow
1. Client sends a request
2. Rate limiter identifies the client
3. Current usage is checked from shared state
4. If limit exceeded → request rejected (e.g., HTTP 429)
5. If allowed → request forwarded to the service

This decision must be fast and consistent across instances.

---

## Tradeoffs & Design Considerations
- **Accuracy vs performance**: precise algorithms cost more
- **Centralized vs distributed state**: simplicity vs scalability
- **Strict limits vs burst tolerance**: user experience tradeoff
- **Fail-open vs fail-closed** behavior during outages

---

## Edge Cases (Not Fully Explored Yet)
- Clock skew in distributed systems
- Handling retries and duplicate requests
- Behavior during cache or store failures

---

## Understandings

Rate limiting protects shared resouced so one actor doesn't ruin things for everyone else. 

**Who are we limiting?** The common identities are User, API Key, IP address. Each of these gets its own counter. 

---

## Jargons

**Downstream** - The things your request touches later. 
Eg. ApI --> Service --> Database. 
Database is _downstream_ of the service. If too many requests hit the DB, everything dies. 
Protect downstream = don't overload the DB or other services. 

**Business Semantics** - Rules that depend on what the API actually does.
Eg. /login --> sensitive --> strict limits, /getPosts --> cheap --> looser limits
Business-aware = different rules for different endpoints

**Best-effor enforcement** - meaning "We try our best, but small mistakes are okay."
Eg. Limit it 100/min, Sometimes user gets 101 or 102 which is fine since system is still safe.
Hard enforcement = Never exceed, even by 1. 

---

## Progress Log
- Day 1: Understood what, why, when, where, and how rate limiting works