class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        
        # 2021.03.07
        # 1st solution: sliding window
        # time O(n): 256 ms (33%), memory O(1): 15.1 MB (10%)
        """
        n = len(customers)
        total = 0
        for i in range(n):
            if grumpy[i] == 0:
                total += customers[i]
        window = 0
        for i in range(minutes):
            if grumpy[i] == 1:
                window += customers[i]
        res = window
        for i in range(minutes, n):
            if grumpy[i] == 1:
                window += customers[i]
            if grumpy[i - minutes] == 1:
                window -= customers[i - minutes]
            res = max(res, window)
        return res + total
        """
        # 2nd solution: prefix sum
        # time O(n): 204 ms (91%), memory O(n): 15.1 MB (10%)
        n = len(customers)
        total = 0
        for i in range(n):
            if grumpy[i] == 0:
                total += customers[i]
        prefix = [0 for _ in range(n + 1)]
        for i in range(1, n + 1):
            prefix[i] = prefix[i - 1] + customers[i - 1] * grumpy[i - 1]
        res = 0
        for i in range(n - minutes + 1):
            res = max(res, prefix[i + minutes] - prefix[i])
        return res + total