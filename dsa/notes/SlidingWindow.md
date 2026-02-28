# Sliding Window

**What Invariant Sliding Window relies on?**
When all numbers are non-negative, expanding the window can only increase (or keep) the sum, and shrinking the window can only decrease (or keep) the sum.
Because of that:
- If `sum < k` --> expand right
- If `sum > k` --> shrink left
Both decisions are **safe** and **deterministic**. So the main concern is **monotonicity**.

**Why can't we use sliding window when negatives exist?**
Because shrinking the window doesn't guarantee the sum decrease, so we lose the monotonic property.

---

# Problems

## Longest Subarray with Sum = K
_constraint_: all numbers are positive

**Pattern**: Sliding window
**Reason**:
- Because all numbers are +ve, expanding the window always _increases_ the sum and shrinking the window always _decreases_ the sum. 

### Mental template:
1. Initialize `left=0`, `sum=0`, `maxLen=0`
2. For each `right`:
    - sum += nums[right]
    - While `sum > K`:
        - `sum -= nums[left]`
        - `left++`
    - If `sum == k`:
        - `maxLen = max(maxLen, right - left + 1)`

**Time**: O(n)
**Space**: O(1)