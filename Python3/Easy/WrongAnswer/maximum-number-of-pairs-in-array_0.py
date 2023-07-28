class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        
        d = {}
        for n in nums:
            d[n] = d.get(n, 0) + 1
        res = 0
        for k, v in d.items():
            if v >= 2:
                res += v * (v - 1) // 2
        return [res, len(nums) - res]