class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], indexDiff: int, valueDiff: int) -> bool:
        
        if valueDiff == 0:
            return len(set(nums)) != len(nums)
        for i in range(len(nums)):
            for j in range(i + 1, min(i + indexDiff + 1, len(nums))):
                if abs(nums[i] - nums[j]) <= valueDiff:
                    return True
        return False