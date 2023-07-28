class Solution:
    def arraySign(self, nums: List[int]) -> int:
        
        if 0 in nums:
            return 0
        if all([i > 0 for i in nums]):
            return 1
        if all([i < 0 for i in nums]):
            return -1
        return -1 if sum([1 for i in nums if i < 0]) % 2 else 1