# 🔗 Linked List

---

# 🧠 Core Idea

A **Linked List** is a linear data structure where elements are stored in **nodes**.

Each node contains:

```text
[value | nextPointer]
```

Unlike arrays:

- Memory is NOT contiguous
- Dynamic size
- Easy insertion/deletion
- Slow random access

---

# 📦 Types of Linked Lists

## 1. Singly Linked List

```text
1 -> 2 -> 3 -> 4 -> null
```

Each node points to next node.

---

## 2. Doubly Linked List

```text
null <- 1 <-> 2 <-> 3 -> null
```

Each node has:

```java
prev
next
```

Useful for:

- Browser history
- LRU cache
- Bidirectional traversal

---

## 3. Circular Linked List

```text
1 -> 2 -> 3 -> 1
```

Tail connects back to head.

Used in:

- Round robin scheduling
- Cyclic buffers

---

# 📌 Linked List vs Array

| Feature | Array | Linked List |
|---|---|---|
| Memory | Contiguous | Non-contiguous |
| Access | O(1) | O(n) |
| Insert/Delete at head | O(n) | O(1) |
| Insert/Delete in middle | O(n) | O(1) if node known |
| Cache friendly | Yes | No |
| Dynamic size | Hard | Easy |

---

# 🧱 Basic Node Structure

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
```

---

# ⚡ Important Interview Observation

Most linked list problems become easy if you master:

1. Pointer manipulation
2. Dummy node usage
3. Slow/Fast pointers
4. Reversal
5. Breaking problems into smaller linked lists

---

# 🧠 Golden Rules

## Rule 1: Draw the pointers

Always dry run visually.

Interviewers care about pointer correctness.

---

## Rule 2: Save next before changing links

```java
ListNode next = curr.next;
curr.next = prev;
```

Otherwise you lose the list.

---

## Rule 3: Dummy node simplifies edge cases

Without dummy:

- Head deletion becomes messy

With dummy:

- Uniform handling

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
```

---

## Rule 4: Most problems are variations of

- Reverse
- Merge
- Detect cycle
- Split
- Traverse with conditions

---

# ⏱️ Time Complexity Cheat Sheet

| Operation | Complexity |
|---|---|
| Traverse | O(n) |
| Insert at head | O(1) |
| Insert at tail | O(n) |
| Delete node | O(1) if node known |
| Search | O(n) |
| Reverse | O(n) |

---

# 🔥 Most Important Patterns

# Pattern 1 — Traversal

```java
ListNode curr = head;

while (curr != null) {
    System.out.println(curr.val);
    curr = curr.next;
}
```

---

# Pattern 2 — Reverse Linked List

MOST IMPORTANT.

## Iterative Reverse

```java
ListNode prev = null;
ListNode curr = head;

while (curr != null) {
    ListNode next = curr.next;

    curr.next = prev;

    prev = curr;
    curr = next;
}

return prev;
```

---

## Visual Understanding

Before:

```text
1 -> 2 -> 3 -> null
```

After:

```text
null <- 1 <- 2 <- 3
```

Final:

```text
3 -> 2 -> 1 -> null
```

---

## Reverse Template

```java
while (curr != null) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
```

Memorize this.

---

## Recursive Reverse

```java
public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode newHead = reverse(head.next);

    head.next.next = head;
    head.next = null;

    return newHead;
}
```

---

# Pattern 3 — Slow & Fast Pointer

Used in:

- Find middle
- Detect cycle
- Happy number
- Find nth from end

---

## Find Middle

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

---

## Why It Works

Fast moves 2 steps.

Slow moves 1 step.

When fast reaches end:

```text
slow = middle
```

---

# Pattern 4 — Detect Cycle (Floyd Cycle Detection)

## Idea

If cycle exists:

- Slow moves 1
- Fast moves 2
- They eventually meet

---

## Code

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
        return true;
    }
}

return false;
```

---

## Why Floyd Works

Inside cycle:

- Fast gains 1 step each iteration
- Eventually catches slow

---

# Pattern 5 — Merge Two Lists

## Sorted Merge

```java
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;

while (l1 != null && l2 != null) {

    if (l1.val <= l2.val) {
        tail.next = l1;
        l1 = l1.next;
    } else {
        tail.next = l2;
        l2 = l2.next;
    }

    tail = tail.next;
}

tail.next = (l1 != null) ? l1 : l2;

return dummy.next;
```

---

## Key Observation

Use tail pointer to build answer incrementally.

---

# Pattern 6 — Remove Nth Node From End

## Trick

Move fast pointer `n` steps first.

Then move both together.

---

## Code

```java
ListNode dummy = new ListNode(0);
dummy.next = head;

ListNode slow = dummy;
ListNode fast = dummy;

for (int i = 0; i <= n; i++) {
    fast = fast.next;
}

while (fast != null) {
    slow = slow.next;
    fast = fast.next;
}

slow.next = slow.next.next;

return dummy.next;
```

---

# Pattern 7 — Dummy Node Technique

This technique appears everywhere.

Without dummy:

```text
Delete head requires special handling
```

With dummy:

```text
Everything becomes normal deletion
```

---

# Pattern 8 — Two Pointer Distance Technique

Maintain a gap.

Used in:

- Nth from end
- Cycle problems
- Palindrome

---

# Pattern 9 — Palindrome Linked List

## Optimal Approach

1. Find middle
2. Reverse second half
3. Compare both halves

---

## Code

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

ListNode second = reverse(slow);

ListNode first = head;

while (second != null) {

    if (first.val != second.val) {
        return false;
    }

    first = first.next;
    second = second.next;
}

return true;
```

---

# Pattern 10 — Reverse Between

## Key Idea

Split into 3 parts:

```text
before -> reversedPart -> after
```

Reconnect carefully.

---

# Pattern 11 — K Group Reversal

Very common SDE2 problem.

## Core Idea

1. Find kth node
2. Reverse group
3. Reconnect
4. Repeat

---

# Pattern 12 — Linked List as Number

Examples:

- Add Two Numbers
- Multiply lists

---

## Add Two Numbers

Most important concept:

```text
carry propagation
```

---

## Code

```java
ListNode dummy = new ListNode(0);
ListNode curr = dummy;

int carry = 0;

while (l1 != null || l2 != null || carry != 0) {

    int sum = carry;

    if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
    }

    if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
    }

    carry = sum / 10;

    curr.next = new ListNode(sum % 10);
    curr = curr.next;
}

return dummy.next;
```

---

# 🔥 Super Important Interview Patterns

| Problem Type | Main Technique |
|---|---|
| Reverse | 3 pointers |
| Find middle | Slow/Fast |
| Detect cycle | Floyd |
| Merge | Dummy + Tail |
| Remove node | Dummy |
| Palindrome | Reverse second half |
| K-group reverse | Segment reverse |
| Deep copy random pointer | HashMap |
| LRU Cache | DLL + HashMap |

---

# 🧠 How to Think in Linked List Problems

## Question 1

Can this be solved by reversing?

---

## Question 2

Can slow-fast pointers help?

---

## Question 3

Can dummy node remove edge cases?

---

## Question 4

Can I split into smaller lists?

---

## Question 5

Am I losing references?

VERY IMPORTANT.

Always store next first.

---

# 🚨 Common Mistakes

## Mistake 1 — Losing next pointer

Wrong:

```java
curr.next = prev;
curr = curr.next;
```

You lost original next.

---

## Mistake 2 — Forgetting dummy node

Creates many edge cases.

---

## Mistake 3 — Infinite loops

Wrong pointer updates.

---

## Mistake 4 — Null pointer exceptions

Always check:

```java
fast != null && fast.next != null
```

---

## Mistake 5 — Returning wrong head

After reverse:

```java
return prev;
```

NOT original head.

---

# 🔥 Advanced Linked List Concepts

## 1. Intersection of Two Lists

Technique:

```text
Pointer switching
```

---

## Elegant Solution

```java
ListNode a = headA;
ListNode b = headB;

while (a != b) {

    a = (a == null) ? headB : a.next;
    b = (b == null) ? headA : b.next;
}

return a;
```

---

## Why It Works

Both travel:

```text
lengthA + lengthB
```

Eventually align.

---

## 2. Deep Copy with Random Pointer

Use:

```text
HashMap<OldNode, NewNode>
```

OR

```text
Interweaving technique
```

---

## 3. Flatten Linked List

Seen in:

- multilevel DLL
- bottom pointers

---

## 4. LRU Cache

Most famous design question.

Uses:

```text
HashMap + Doubly Linked List
```

Why DLL?

```text
O(1) delete
```

---

# 🧩 Important Edge Cases

## Empty List

```java
head == null
```

---

## Single Node

```text
1 -> null
```

---

## Two Nodes

Common reversal bugs happen here.

---

## Even Length vs Odd Length

Especially in:

- palindrome
- middle finding

---

## Cycle Present

Traversal may never end.

---

# 🧠 Interview Strategy

## Step 1

Draw nodes.

---

## Step 2

Mark pointer movement.

---

## Step 3

Write brute force first.

---

## Step 4

Optimize space/time.

---

## Step 5

Handle edge cases.

---

# 🔥 Most Important Linked List Problems

## Easy

1. Reverse Linked List
2. Merge Two Sorted Lists
3. Linked List Cycle
4. Middle of Linked List
5. Remove Duplicates
6. Palindrome Linked List

---

## Medium

1. Add Two Numbers
2. Remove Nth Node From End
3. Reorder List
4. Odd Even Linked List
5. Sort List
6. Partition List
7. Rotate List
8. Swap Nodes in Pairs

---

## Hard

1. Reverse Nodes in K Group
2. Merge K Sorted Lists
3. Copy List with Random Pointer
4. LRU Cache
5. Flatten Multilevel DLL

---

# 🔥 Must Memorize Templates

## Reverse Template

```java
prev = null;

while (curr != null) {
    next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
```

---

## Slow Fast Template

```java
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

---

## Merge Template

```java
while (l1 != null && l2 != null)
```

---

## Dummy Node Template

```java
ListNode dummy = new ListNode(0);
dummy.next = head;
```

---

# 🚀 Problem Solving Roadmap

## Phase 1 — Basics

- Traversal
- Insert
- Delete
- Reverse

---

## Phase 2 — Two Pointers

- Middle
- Cycle
- Nth from end

---

## Phase 3 — Reversal Variants

- Reverse II
- K Group
- Palindrome

---

## Phase 4 — Advanced

- Random pointer
- Merge K
- LRU Cache

---

# 🧠 Interview Insight

Most Linked List interview problems are testing:

```text
Can you manipulate pointers carefully?
```

NOT memorization.

---

# 🔥 Best Practice Problems (LeetCode)

## Beginner

1. Reverse Linked List  
   https://leetcode.com/problems/reverse-linked-list/

2. Middle of the Linked List  
   https://leetcode.com/problems/middle-of-the-linked-list/

3. Linked List Cycle  
   https://leetcode.com/problems/linked-list-cycle/

4. Merge Two Sorted Lists  
   https://leetcode.com/problems/merge-two-sorted-lists/

5. Remove Duplicates from Sorted List  
   https://leetcode.com/problems/remove-duplicates-from-sorted-list/

---

## Intermediate

6. Add Two Numbers  
   https://leetcode.com/problems/add-two-numbers/

7. Remove Nth Node From End  
   https://leetcode.com/problems/remove-nth-node-from-end-of-list/

8. Palindrome Linked List  
   https://leetcode.com/problems/palindrome-linked-list/

9. Reorder List  
   https://leetcode.com/problems/reorder-list/

10. Odd Even Linked List  
    https://leetcode.com/problems/odd-even-linked-list/

11. Partition List  
    https://leetcode.com/problems/partition-list/

12. Sort List  
    https://leetcode.com/problems/sort-list/

13. Rotate List  
    https://leetcode.com/problems/rotate-list/

14. Swap Nodes in Pairs  
    https://leetcode.com/problems/swap-nodes-in-pairs/

---

## Advanced

15. Reverse Nodes in K Group  
    https://leetcode.com/problems/reverse-nodes-in-k-group/

16. Merge K Sorted Lists  
    https://leetcode.com/problems/merge-k-sorted-lists/

17. Copy List with Random Pointer  
    https://leetcode.com/problems/copy-list-with-random-pointer/

18. LRU Cache  
    https://leetcode.com/problems/lru-cache/

19. Flatten a Multilevel Doubly Linked List  
    https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

20. Intersection of Two Linked Lists  
    https://leetcode.com/problems/intersection-of-two-linked-lists/

---

# 🔥 Best External Resources

## LeetCode Linked List Summary

https://leetcode.com/problems/add-two-numbers/solutions/1340/a-summary-about-how-to-solve-linked-list-problem-c/

---

## Become Master in Linked List

https://leetcode.com/discuss/post/1800120/become-master-in-linked-list-by-hi-malik-qvdr/

---

## Linked List Series

https://medium.com/@tahichy48/linked-list-series-1c045f50e20d

---

# ✅ Final Revision Checklist

Before interview make sure you can do WITHOUT HELP:

- Reverse list
- Find middle
- Detect cycle
- Merge lists
- Remove nth node
- Reverse k-group
- Palindrome list
- Copy random pointer
- LRU Cache


