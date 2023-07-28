class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        
        n = len(customers)
        if n == 1:
            return customers[0]
        satisfied = 0
        for i in range(n):
            if grumpy[i] == 0:
                satisfied += customers[i]
        max_satisfied = satisfied
        left = 0
        right = minutes - 1
        while right < n:
            for j in range(left, right + 1):
                if grumpy[j] == 1:
                    satisfied += customers[j]
            max_satisfied = max(satisfied, max_satisfied)
            if grumpy[left] == 1:
                satisfied -= customers[left]
            left += 1
            right += 1
        return max_satisfied