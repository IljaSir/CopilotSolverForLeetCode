class Solution:
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        
        return sorted([i for i, n in enumerate(nums) if n == target])