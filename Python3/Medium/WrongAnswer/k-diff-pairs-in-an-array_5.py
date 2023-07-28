class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        print(nums)
        i, j = 0, 1
        count = 0
        while j < len(nums):
            if nums[j] - nums[i] == k:
                count += 1
                i += 1
                j += 1
                while i < len(nums) and nums[i] == nums[i - 1]:
                    i += 1
                while j < len(nums) and nums[j] == nums[j - 1]:
                    j += 1
            elif nums[j] - nums[i] < k:
                j += 1
            else:
                i += 1
                if i == j:
                    j += 1
        return count