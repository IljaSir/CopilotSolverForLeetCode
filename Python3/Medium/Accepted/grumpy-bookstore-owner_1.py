class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        
        n = len(customers)
        s = sum(customers[i] for i in range(n) if grumpy[i] == 0)
        s1 = sum(customers[i] for i in range(minutes) if grumpy[i] == 1)
        ans = s1
        for i in range(1, n - minutes + 1):
            s1 -= customers[i - 1] if grumpy[i - 1] == 1 else 0
            s1 += customers[i + minutes - 1] if grumpy[i + minutes - 1] == 1 else 0
            ans = max(ans, s1)
        return s + ans