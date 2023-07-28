class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        
        for i in range(len(nums)):
            if nums[i] == target:
                return min(abs(i-start), abs(len(nums)-i+start))