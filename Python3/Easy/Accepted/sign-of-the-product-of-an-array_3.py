class Solution:
    def arraySign(self, nums: List[int]) -> int:
        
        p = 1
        for n in nums:
            p *= n
        return (p > 0) - (p < 0)