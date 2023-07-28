class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        
        d = dict()
        for n in nums:
            d[n] = d.get(n, 0) + 1
        keys = sorted(d.keys())
        res = 0
        for i, n in enumerate(keys):
            if n == 0:
                if k == 0:
                    res += d[n] * (d[n] - 1) // 2
            elif n * 2 == k:
                res += d[n] * (d[n] - 1) // 2
            elif (k - n) in d:
                res += d[n] * d[k - n]
        return res