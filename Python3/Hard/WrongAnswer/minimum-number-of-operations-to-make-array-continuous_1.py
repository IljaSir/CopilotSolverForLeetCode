class Solution:
    def minOperations(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = n
        for i in range(n):
            j = bisect.bisect_left(nums, nums[i] + n)
            res = min(res, n - (j - i))
        return res