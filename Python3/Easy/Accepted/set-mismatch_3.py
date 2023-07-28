class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        
        missing = sum(range(1, len(nums) + 1)) - sum(set(nums))
        return [sum(nums) - sum(set(nums)), missing]