# Prefix Sum + Hashmap

**Why we do NOT overwrite an existing prefix sum?**
Overwriting would replace the earliest index with a later one, which would reduce the subarray length and break the goal of maximizing length.

**Pattern** --> Prefix sum + hashmap (earliest index) → longest subarray


---

# Problems

## Subarray Sum Equals K
_Numbers can be negative_

**Pattern**: Prefix sum + Hashmap
**Reason**:
I use prefix sum and a hashmap because I'm looking for earlier prefix sums that differ from the current sum by K. 

**Core Idea**:
If `prefix[j] - prefix[i] = k`, then subarray `(i+1 --> j)` sums to K
Rearranged: `prefix[i] = prefix[j] - k`

### Generic flow
1. `sum = 0`
2. `map = { 0 : 1 }`
3. For each element
    - `sum += element`
    - if `map` contains `(sum-k)`:
        - add `map[sum - k]` to answer
    - `map[sum]++`