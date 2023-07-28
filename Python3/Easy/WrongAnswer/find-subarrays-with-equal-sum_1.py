class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        
        # O(n^2) - 2 nested for loops
        # O(1) - constant space
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if sum(nums[i:j]) == sum(nums[j:j + 2]):
                    return True
        return False