class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        nums = sorted(nums)
        res = 0
        i = 0
        while i < len(nums):
            j = i + 1
            while j < len(nums) and nums[j] - nums[i] < k:
                j += 1
            if j < len(nums) and nums[j] - nums[i] == k:
                res += 1
            while i < len(nums) - 1 and nums[i] == nums[i + 1]:
                i += 1
            i += 1
        return res