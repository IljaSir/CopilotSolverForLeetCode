class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        if k < 0:
            return 0
        result = 0
        nums.sort()
        i = 0
        j = 1
        while j < len(nums):
            if i == j:
                j += 1
                continue
            if nums[j] - nums[i] == k:
                result += 1
                i += 1
                j += 1
                while j < len(nums) and nums[j] == nums[j-1]:
                    j += 1
            elif nums[j] - nums[i] > k:
                i += 1
            else:
                j += 1
        return result