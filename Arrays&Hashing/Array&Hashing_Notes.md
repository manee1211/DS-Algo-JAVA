# 📦 Arrays & Hashing Interview Notes

---

# 🧠 Core Idea

> Use hashing to reduce time complexity from **O(n²) → O(n)**

- Array → O(1) index access
- HashMap / HashSet → O(1) lookup (average)

---

# 🔥 Problem Classification

| Problem Type | Pattern |
|--------------|--------|
| Pair sum | HashMap |
| Subarray sum | Prefix sum + HashMap |
| Substring problems | Sliding window |
| Duplicates | HashSet / Frequency |
| Triplets | Sorting + Two pointers |
| Max subarray | Kadane |
| Consecutive elements | HashSet |

---

# 🚀 Core Patterns

---

## 1. Frequency Counting

### Use when:
- duplicates
- anagrams
- counting

```java
Map<Integer, Integer> freq = new HashMap<>();

for (int x : arr) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
```

---

## 2. Two Sum (HashMap)

```java
Map<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < n; i++) {
    int need = target - arr[i];

    if (map.containsKey(need)) {
        return new int[]{map.get(need), i};
    }

    map.put(arr[i], i);
}
```

---

## 3. Prefix Sum + HashMap

Count subarrays with sum = k

```java
Map<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int sum = 0, count = 0;

for (int x : arr) {
    sum += x;
    count += map.getOrDefault(sum - k, 0);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
```

---

## 4. Sliding Window

### Fixed Window

```java
int sum = 0;

for (int i = 0; i < k; i++) {
    sum += arr[i];
}

for (int i = k; i < n; i++) {
    sum += arr[i] - arr[i - k];
}
```

### Variable Window

```java
int l = 0;

for (int r = 0; r < n; r++) {

    while (/* invalid condition */) {
        l++;
    }

    // update answer
}
```

---

## 5. Longest Substring Without Repeating Characters

```java
Set<Character> set = new HashSet<>();
int l = 0, maxLen = 0;

for (int r = 0; r < s.length(); r++) {

    while (set.contains(s.charAt(r))) {
        set.remove(s.charAt(l));
        l++;
    }

    set.add(s.charAt(r));
    maxLen = Math.max(maxLen, r - l + 1);
}
```

---

## 6. Sorting + Two Pointers

```java
Arrays.sort(arr);

int l = 0, r = n - 1;

while (l < r) {
    int sum = arr[l] + arr[r];

    if (sum == target) {
        break;
    } else if (sum < target) {
        l++;
    } else {
        r--;
    }
}
```

---

## 7. Kadane’s Algorithm (Maximum Subarray)

```java
int maxSum = arr[0], curr = arr[0];

for (int i = 1; i < n; i++) {
    curr = Math.max(arr[i], curr + arr[i]);
    maxSum = Math.max(maxSum, curr);
}
```

---

## 8. HashSet for O(1) Lookup

```java
Set<Integer> set = new HashSet<>();

for (int x : arr) {
    set.add(x);
}
```

---

# 🚀 Advanced Patterns (SDE2 Level)

## 9. Prefix XOR

Used in:
- subarray XOR problems

---

## 10. Difference Array

```java
diff[l] += val;
diff[r + 1] -= val;
```

---

## 11. Coordinate Compression

Map large values → small indices

---

## 12. Bucket / Counting Sort

Use when value range is small

---

# ⚠️ Edge Cases (Very Important)

- empty array
- single element
- duplicates
- negative numbers
- overflow
- large input (10^5+)

---

# ⚖️ Trade-offs (SDE2 Expectation)

| Approach | Time | Space |
|----------|------|-------|
| Brute force | O(n²) | O(1) |
| HashMap | O(n) | O(n) |
| Sorting | O(n log n) | O(1) |

---

👉 Always explain:

- Why hashing?
- Can we reduce space?
- Is sorting acceptable?

---

# 🧠 Interview Thinking Process

1. Start with brute force
2. Identify pattern:
    - Hashing?
    - Sliding window?
    - Prefix sum?
3. Optimize
4. Discuss complexity
5. Handle edge cases

---

# 🎯 Must-Do Problems

- Two Sum
- Contains Duplicate
- Valid Anagram
- Subarray Sum Equals K
- Longest Substring Without Repeating Characters
- 3Sum
- Product of Array Except Self
- Longest Consecutive Sequence

---

# 🔥 Pattern Recognition Cheat Sheet

| If question says | Use |
|------------------|-----|
| "pair sum" | HashMap |
| "subarray sum" | Prefix sum |
| "longest substring" | Sliding window |
| "triplets" | Sorting + two pointers |
| "maximum subarray" | Kadane |
| "consecutive sequence" | HashSet |

---

# 🏁 Final Summary

Arrays + Hashing = reduce brute force to optimal using lookup + patterns