class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        from collections import Counter
        c = Counter(ages)
        res = 0
        for i in range(1, 121):
            for j in range(1, 121):
                if i <= 0.5 * j + 7 or i > j or i > 100 and j < 100:
                    continue
                res += c[i] * c[j]
                if i == j:
                    res -= c[i]
        return res