class Solution:
    def arraySign(self, nums: List[int]) -> int:
        
        return 0 if 0 in nums else -1 if sum(map(lambda x: x < 0, nums)) % 2 else 1