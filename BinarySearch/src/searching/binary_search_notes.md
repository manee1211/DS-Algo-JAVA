# 🔍 Binary Search — Complete Notes

## 🧠 Core Idea
Binary search is NOT about arrays.
It is about finding a boundary in a monotonic function.


Every binary search problem reduces to:

Find a boundary where FALSE → TRUE (or TRUE → FALSE)

---

## 📌 Pattern
F F F F T T T T → First TRUE  
T T T T F F F F → Last TRUE  

---

## 🔥 Universal Template (First TRUE)
```java
int l = low, r = high;
while (l < r) {
    int mid = l + (r - l) / 2;
    if (condition(mid)) r = mid;
    else l = mid + 1;
}
return l;
```

---

## 🔥 Universal Template (Last TRUE)
```java
int l = low, r = high;
while (l < r) {
    int mid = l + (r - l + 1) / 2;
    if (condition(mid)) l = mid;
    else r = mid - 1;
}
return l;
```

---

## 📍 Lower Bound
First index where arr[i] >= target

```java
int l = 0, r = n;
while (l < r) {
    int mid = (l + r) / 2;
    if (arr[mid] >= target) r = mid;
    else l = mid + 1;
}
return l;
```

---

## 📍 Upper Bound
First index where arr[i] > target

```java
int l = 0, r = n;
while (l < r) {
    int mid = (l + r) / 2;
    if (arr[mid] > target) r = mid;
    else l = mid + 1;
}
return l;
```

---

## 📍 Insert Position
Same as lower bound

---

## 📍 Count Occurrences
count = upper_bound - lower_bound

---

## 📍 Square Root (√x)

Last TRUE: condition(mid) = mid*mid <= x

answer = last TRUE
```java
int l = 0, r = x;
while (l < r) {
    int mid = (l + r + 1) / 2;
    if ((long)mid * mid <= x) l = mid;
    else r = mid - 1;
}
return l;
```
Or Flip to First True: condition(mid) = mid*mid > x

answer = first TRUE - 1
```java
int l = 0, r = x;
while (l < r) {
    int mid = (l + r) / 2;
    if ((long)mid * mid > x) r = mid;
    else l = mid + 1;
}
return l-1;
```

---

## 🚀 Binary Search on Answer
Used for minimum/maximum valid problems

```java
int l = low, r = high;
while (l < r) {
    int mid = (l + r) / 2;
    if (isValid(mid)) r = mid;
    else l = mid + 1;
}
return l;
```

---

## ⚠️ Golden Rules
- r = mid → use l < r
- l = mid → use right bias
- l <= r → use mid ± 1
- never mix templates

---

## 🧠 One-line Summary
Convert problem → Boolean → Find boundary
