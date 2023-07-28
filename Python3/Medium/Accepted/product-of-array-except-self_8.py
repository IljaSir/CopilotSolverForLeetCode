class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        
        n = len(nums)
        # 1. construct prefix product
        prefix_product = [1] * n
        for i in range(1, n):
            prefix_product[i] = prefix_product[i-1] * nums[i-1]
        # 2. construct suffix product
        suffix_product = [1] * n
        for i in range(n-2, -1, -1):
            suffix_product[i] = suffix_product[i+1] * nums[i+1]
        # 3. construct result
        result = [1] * n
        for i in range(n):
            result[i] = prefix_product[i] * suffix_product[i]
        return result