class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        s = set(nums)
        return [sum(nums) - sum(s), n * (n + 1) // 2 - sum(s)]