class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        
        from collections import defaultdict
        d = defaultdict(int)
        for n in nums:
            d[n % k] += 1
        res = 0
        for i in range(1, k // 2 + 1):
            res += d[i] * d[k - i]
        if k % 2 == 0:
            res += d[k // 2] * (d[k // 2] - 1) // 2
        res += d[0] * (d[0] - 1) // 2
        return res