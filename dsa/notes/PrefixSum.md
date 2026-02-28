# Prefix Sum + Hashmap

**Why we do NOT overwrite an existing prefix sum?**
Overwriting would replace the earliest index with a later one, which would reduce the subarray length and break the goal of maximizing length.

**Pattern** --> Prefix sum + hashmap (earliest index) → longest subarray