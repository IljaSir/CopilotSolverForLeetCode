class Solution:
    def arraySign(self, nums: List[int]) -> int:
        
        product = 1
        for i in nums:
            product *= i
        return product / abs(product) if product != 0 else 0