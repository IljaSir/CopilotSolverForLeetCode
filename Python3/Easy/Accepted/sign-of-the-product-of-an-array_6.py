class Solution:
    def arraySign(self, nums: List[int]) -> int:
        
        return 0 if 0 in nums else (-1)**(sum(1 for x in nums if x < 0) % 2)