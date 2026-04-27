# 📚 Stack & Queue Interview Notes

---

## 🧠 Core Idea

> Use **Stack (LIFO)** and **Queue (FIFO)** to manage order, constraints, and sequential processing efficiently

- Stack → Last In First Out (LIFO)
- Queue → First In First Out (FIFO)
- Helps reduce complexity from **O(n²) → O(n)** in many problems

---

## 🔥 When to Use

- Next greater/smaller element
- Parentheses validation
- Expression evaluation
- Monotonic problems
- Sliding window (deque)
- BFS (level order traversal)
- Task scheduling / streaming data

---

## 🚀 Problem Classification

| Problem Type                  | Pattern                          |
|------------------------------|----------------------------------|
| Next greater/smaller         | Monotonic Stack                  |
| Parentheses matching         | Stack                            |
| Histogram / rectangle        | Stack                            |
| Sliding window max/min       | Monotonic Deque                  |
| BFS traversal                | Queue                            |
| Task scheduling              | Queue / Heap                     |
| Expression evaluation        | Stack                            |

---

## 🚀 Core Patterns

---

## 1. Basic Stack Usage

### Use when:
- reverse order needed
- tracking previous states

```java
Stack<Integer> stack = new Stack<>();

for (int x : arr) {
    while (!stack.isEmpty() && stack.peek() > x) {
        stack.pop();
    }
    stack.push(x);
}
```

---

## 2. Monotonic Stack (Next Greater Element)

### Use when:
- next greater/smaller element
- range queries

```java
Stack<Integer> stack = new Stack<>();
int[] res = new int[n];

for (int i = n - 1; i >= 0; i--) {

    while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
    }

    res[i] = stack.isEmpty() ? -1 : stack.peek();
    stack.push(arr[i]);
}
```

---

## 3. Monotonic Stack (Index Based)

```java
Stack<Integer> stack = new Stack<>();

for (int i = 0; i < n; i++) {

    while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int idx = stack.pop();
        // process idx
    }

    stack.push(i);
}
```

---

## 4. Valid Parentheses

```java
Stack<Character> stack = new Stack<>();

for (char c : s.toCharArray()) {
    if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
    } else {
        if (stack.isEmpty()) return false;

        char top = stack.pop();
        if ((c == ')' && top != '(') ||
            (c == '}' && top != '{') ||
            (c == ']' && top != '[')) {
            return false;
        }
    }
}

return stack.isEmpty();
```

---

## 5. Largest Rectangle in Histogram

```java
Stack<Integer> stack = new Stack<>();
int maxArea = 0;

for (int i = 0; i <= n; i++) {
    int h = (i == n) ? 0 : heights[i];

    while (!stack.isEmpty() && h < heights[stack.peek()]) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
    }

    stack.push(i);
}
```

---

## 6. Queue (Basic BFS)

```java
Queue<Integer> q = new LinkedList<>();
q.offer(start);

while (!q.isEmpty()) {
    int curr = q.poll();

    for (int next : neighbors) {
        q.offer(next);
    }
}
```

---

## 7. Sliding Window Maximum (Deque)

### Use when:
- window max/min in O(n)

```java
Deque<Integer> dq = new LinkedList<>();

for (int i = 0; i < n; i++) {

    while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
    }

    while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
        dq.pollLast();
    }

    dq.offerLast(i);

    if (i >= k - 1) {
        // dq.peekFirst() is max index
    }
}
```

---

## 8. Implement Stack using Queue

```java
Queue<Integer> q = new LinkedList<>();

public void push(int x) {
    q.offer(x);
    for (int i = 0; i < q.size() - 1; i++) {
        q.offer(q.poll());
    }
}
```

---

## ⚠️ Edge Cases

- empty input
- single element
- all increasing / decreasing
- duplicates
- large input (10^5+)
- stack overflow (recursion vs iterative)

---

## ⚖️ Trade-offs

| Approach            | Time  | Space |
|---------------------|-------|-------|
| Brute force         | O(n²) | O(1)  |
| Stack / Queue       | O(n)  | O(n)  |
| Deque optimization  | O(n)  | O(n)  |

---

## 👉 Key Observations (Interview Gold)

- Need **previous/next greater** → Monotonic Stack
- Need **order processing** → Queue
- Need **window max/min** → Deque
- Stack often stores **indices**, not values
- Think: can we maintain order while popping useless elements?

---

## 🧠 Interview Thinking Process

1. Start brute force
2. Check if order matters → Stack / Queue
3. Can we maintain monotonic property?
4. Use stack to eliminate unnecessary elements
5. Optimize to O(n)
6. Handle edge cases

---

## 🎯 Must-Do Problems

- Valid Parentheses
- Next Greater Element
- Daily Temperatures
- Largest Rectangle in Histogram
- Sliding Window Maximum
- Min Stack
- Implement Queue using Stacks
- Rotting Oranges (BFS)

---

## 🔥 Pattern Recognition Cheat Sheet

| If question says              | Use                      |
|------------------------------|---------------------------|
| "next greater/smaller"       | Monotonic Stack           |
| "valid parentheses"          | Stack                     |
| "histogram / rectangle"      | Stack                     |
| "sliding window max/min"     | Deque                     |
| "level order / shortest path"| Queue (BFS)               |
| "stream / real-time data"    | Queue                     |

---

## 🏁 Final Summary

> Stack & Queue = manage order + eliminate unnecessary work using LIFO/FIFO + monotonic logic