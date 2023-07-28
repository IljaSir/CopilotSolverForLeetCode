class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        
        n = len(nums)
        presum = [0]
        for i in range(n):
            presum.append(presum[-1] + nums[i])
        presum = sorted(presum)
        res = 0
        for i in range(n):
            res += bisect.bisect_right(presum, presum[i+1] - lower) - bisect.bisect_left(presum, presum[i+1] - upper)
        return res