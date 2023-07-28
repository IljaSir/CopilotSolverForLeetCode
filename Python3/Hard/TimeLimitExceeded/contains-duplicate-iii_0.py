class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], indexDiff: int, valueDiff: int) -> bool:
        
        for i in range(len(nums)):
            for j in range(i + 1, i + indexDiff + 1):
                if j >= len(nums):
                    break
                if abs(nums[i] - nums[j]) <= valueDiff:
                    return True
        return False