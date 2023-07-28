class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        
        return sum(collections.Counter(nums).values())