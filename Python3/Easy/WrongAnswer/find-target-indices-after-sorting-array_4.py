class Solution:
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        
        return sorted([i for i, x in enumerate(nums) if x == target])