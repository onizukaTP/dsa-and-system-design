# Sliding Window

**What Invariant Sliding Window relies on?**
When all numbers are non-negative, expanding the window can only increase (or keep) the sum, and shrinking the window can only decrease (or keep) the sum.
Because of that:
- If `sum < k` --> expand right
- If `sum > k` --> shrink left
Both decisions are **safe** and **deterministic**. So the main concern is **monotonicity**.