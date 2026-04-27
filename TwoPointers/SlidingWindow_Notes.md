# 🪟 Sliding Window — Interview Notes

---

## 🧠 Core Idea

> Maintain a **window (subarray / substring)** and adjust it dynamically to avoid recomputation

- Convert nested loops **O(n²) → O(n)**
- Use two pointers: **left (l), right (r)**
- Expand → include elements
- Shrink → remove invalid elements

---

## 🔥 When to Use

- Subarray / substring problems
- Longest / shortest window
- Fixed-size window problems
- Count of valid subarrays
- Problems with constraints (sum, distinct chars, frequency)

---

## 🚀 Problem Classification

| Problem Type                  | Pattern                     |
|------------------------------|-----------------------------|
| Fixed window size            | Sliding sum                 |
| Variable window              | Expand + shrink             |
| Longest substring            | Set / Map + window          |
| Count subarrays              | Prefix / window             |
| At most K distinct           | Map + shrink                |
| Minimum window               | Valid + shrink              |

---

## 🚀 Core Patterns

---

## 1. Fixed Size Window

### Use when:
- window size = k
- max/min/sum/avg

```java
int sum = 0;

// first window
for (int i = 0; i < k; i++) {
    sum += arr[i];
}

// slide window
for (int i = k; i < n; i++) {
    sum += arr[i] - arr[i - k];
}
```

---

## 2. Variable Size Window (Template)

```java
int l = 0;

for (int r = 0; r < n; r++) {

    // include element

    while (/* invalid condition */) {
        // remove element
        l++;
    }

    // update answer
}
```

---

## 3. Longest Substring Without Repeating Characters

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

## 4. At Most K Distinct Characters

```java
Map<Character, Integer> map = new HashMap<>();
int l = 0;

for (int r = 0; r < s.length(); r++) {

    map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

    while (map.size() > k) {
        char c = s.charAt(l);
        map.put(c, map.get(c) - 1);

        if (map.get(c) == 0) {
            map.remove(c);
        }

        l++;
    }

    // update answer
}
```

---

## 5. Minimum Window Substring

### Key Idea:
- Expand → satisfy condition
- Shrink → minimize window

```java
Map<Character, Integer> need = new HashMap<>();
Map<Character, Integer> window = new HashMap<>();

int have = 0, needCount = need.size();
int l = 0;

for (int r = 0; r < s.length(); r++) {

    char c = s.charAt(r);
    window.put(c, window.getOrDefault(c, 0) + 1);

    if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
        have++;
    }

    while (have == needCount) {
        // update result

        char left = s.charAt(l);
        window.put(left, window.get(left) - 1);

        if (need.containsKey(left) && window.get(left) < need.get(left)) {
            have--;
        }

        l++;
    }
}
```

---

## 6. Count Subarrays with Sum ≤ K

```java
int l = 0, sum = 0, count = 0;

for (int r = 0; r < n; r++) {
    sum += arr[r];

    while (sum > k) {
        sum -= arr[l];
        l++;
    }

    count += (r - l + 1);
}
```

---

## ⚠️ Edge Cases

- empty string / array
- k = 0
- all elements same
- all unique elements
- negative numbers (careful: sliding window may fail → use prefix sum)
- large input (10^5+)

---

## ⚖️ Trade-offs

| Approach         | Time  | Space |
|------------------|-------|-------|
| Brute force      | O(n²) | O(1)  |
| Sliding Window   | O(n)  | O(1) / O(n) |

---

## 👉 Key Observations (Interview Gold)

- Contiguous subarray/substring → Think sliding window
- Fixed size → simple slide
- Variable size → expand + shrink
- Use **HashMap / Set** for constraints
- Negative numbers → window may break → use prefix sum

---

## 🧠 Interview Thinking Process

1. Identify if contiguous
2. Fixed or variable window?
3. Define invalid condition
4. Expand (r++)
5. Shrink (l++) when invalid
6. Update answer

---

## 🎯 Must-Do Problems

- Maximum Sum Subarray of Size K
- Longest Substring Without Repeating Characters
- Longest Substring with K Distinct
- Minimum Window Substring
- Permutation in String
- Sliding Window Maximum
- Fruits into Baskets

---

## 🔥 Pattern Recognition Cheat Sheet

| If question says              | Use                      |
|------------------------------|---------------------------|
| "subarray / substring"       | Sliding window            |
| "fixed size k"               | Fixed window              |
| "longest substring"          | Expand + shrink           |
| "at most k distinct"         | Map + shrink              |
| "minimum window"             | Valid + shrink            |
| "count subarrays"            | Window counting           |

---

## 🏁 Final Summary

> Sliding Window = dynamic range + expand/shrink + maintain validity to achieve O(n)