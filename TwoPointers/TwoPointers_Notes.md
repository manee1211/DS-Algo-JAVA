# 👉 Two Pointers Interview Notes

---

## 🧠 Core Idea

> Use two indices to traverse data efficiently and reduce time complexity from **O(n²) → O(n)**

- Typically used on **sorted arrays / strings**
- Avoid nested loops by **moving pointers smartly**

---

## 🔥 When to Use

- Sorted array problems
- Pair / triplet sum
- Removing duplicates
- Partitioning problems
- Sliding window variants
- Palindrome checks

---

## 🚀 Problem Classification

| Problem Type            | Pattern                        |
|------------------------|--------------------------------|
| Pair sum (sorted)      | Opposite direction pointers    |
| Triplets               | Sort + Two pointers            |
| Remove duplicates      | Slow & Fast pointer            |
| Partition (0s,1s,2s)   | Dutch National Flag            |
| Palindrome             | Left & Right pointers          |
| Container problems     | Greedy two pointers            |
| Sliding window         | Expand + shrink pointers       |

---

## 🚀 Core Patterns

---

## 1. Opposite Direction (Left & Right)

### Use when:
- sorted array
- pair sum
- minimizing / maximizing

```java
int l = 0, r = n - 1;

while (l < r) {
    int sum = arr[l] + arr[r];

    if (sum == target) {
        // found
        l++;
        r--;
    } else if (sum < target) {
        l++;
    } else {
        r--;
    }
}
```

---

## 2. Remove Duplicates (Slow & Fast Pointer)

### Use when:
- in-place modification
- sorted array

```java
int i = 0;

for (int j = 1; j < n; j++) {
    if (arr[j] != arr[i]) {
        i++;
        arr[i] = arr[j];
    }
}
```

---

## 3. Sliding Window (Dynamic Two Pointers)

### Use when:
- subarray / substring problems
- longest / shortest window

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

## 4. 3Sum / Triplets

### Use when:
- find triplets
- avoid duplicates

```java
Arrays.sort(arr);

for (int i = 0; i < n; i++) {

    if (i > 0 && arr[i] == arr[i - 1]) continue;

    int l = i + 1, r = n - 1;

    while (l < r) {
        int sum = arr[i] + arr[l] + arr[r];

        if (sum == 0) {
            // store answer

            while (l < r && arr[l] == arr[l + 1]) l++;
            while (l < r && arr[r] == arr[r - 1]) r--;

            l++;
            r--;
        } else if (sum < 0) {
            l++;
        } else {
            r--;
        }
    }
}
```

---

## 5. Container With Most Water

### Greedy Two Pointer

```java
int l = 0, r = n - 1;
int maxArea = 0;

while (l < r) {
    int height = Math.min(arr[l], arr[r]);
    int width = r - l;

    maxArea = Math.max(maxArea, height * width);

    if (arr[l] < arr[r]) {
        l++;
    } else {
        r--;
    }
}
```

---

## 6. Dutch National Flag (3 Pointers)

### Use when:
- sorting 0s,1s,2s

```java
int low = 0, mid = 0, high = n - 1;

while (mid <= high) {
    if (arr[mid] == 0) {
        swap(arr, low++, mid++);
    } else if (arr[mid] == 1) {
        mid++;
    } else {
        swap(arr, mid, high--);
    }
}
```

---

## 7. Palindrome Check

```java
int l = 0, r = s.length() - 1;

while (l < r) {
    if (s.charAt(l) != s.charAt(r)) {
        return false;
    }
    l++;
    r--;
}
```

---

## ⚠️ Edge Cases

- empty array
- single element
- all duplicates
- already sorted
- negative numbers
- overflow (sum problems)

---

## ⚖️ Trade-offs

| Approach        | Time  | Space |
|----------------|-------|-------|
| Brute Force    | O(n²) | O(1)  |
| Two Pointers   | O(n)  | O(1)  |

---

## 👉 Key Observations (Interview Gold)

- Array sorted? → Think **two pointers**
- Need O(1) space? → Prefer over HashMap
- Can we avoid extra space? → Use in-place pointer tricks
- Movement logic = core of solution

---

## 🧠 Interview Thinking Process

1. Start brute force
2. Check if sorting helps
3. Can we use two pointers?
4. Decide pointer movement logic
5. Optimize to O(n)
6. Handle duplicates carefully

---

## 🎯 Must-Do Problems

- Two Sum II (sorted)
- 3Sum
- Container With Most Water
- Remove Duplicates from Sorted Array
- Valid Palindrome
- Trapping Rain Water
- Sort Colors (DNF)

---

## 🔥 Pattern Recognition Cheat Sheet

| If question says            | Use                     |
|----------------------------|--------------------------|
| "sorted array pair"        | Two pointers             |
| "triplets"                 | Sort + two pointers      |
| "remove duplicates"        | Slow & fast pointer      |
| "longest substring"        | Sliding window           |
| "max area"                 | Greedy two pointers      |
| "0s 1s 2s sort"            | Dutch National Flag      |

---

## 🏁 Final Summary

> Two Pointers = smart traversal using direction + condition to eliminate nested loops