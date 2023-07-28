class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        count = 0
        for i in range(len(nums)-1):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            for j in range(i+1, len(nums)):
                if nums[j] - nums[i] == k:
                    count += 1
                    break
                if nums[j] - nums[i] > k:
                    break
        return count