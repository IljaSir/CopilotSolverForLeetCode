class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        
        return max([n for n in nums if -n in nums], default=-1)