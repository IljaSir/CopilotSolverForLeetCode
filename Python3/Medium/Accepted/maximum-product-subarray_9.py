class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        
        # brute force
        # find all subarrays
        # find the max product
        # O(n^3)
        # O(1)
        # subarrays = []
        # n = len(nums)
        # for i in range(n):
        #     for j in range(i, n):
        #         subarrays.append(nums[i:j+1])
        # max_product = -float('inf')
        # for subarray in subarrays:
        #     product = 1
        #     for num in subarray:
        #         product *= num
        #     max_product = max(max_product, product)
        # return max_product
        
        # dp
        # O(n)
        # O(n)
        # max_product = [0] * len(nums)
        # min_product = [0] * len(nums)
        # max_product[0] = nums[0]
        # min_product[0] = nums[0]
        # for i in range(1, len(nums)):
        #     max_product[i] = max(max_product[i-1] * nums[i], min_product[i-1] * nums[i], nums[i])
        #     min_product[i] = min(max_product[i-1] * nums[i], min_product[i-1] * nums[i], nums[i])
        # return max(max_product)
        
        # dp
        # O(n)
        # O(1)
        max_product = nums[0]
        min_product = nums[0]
        ans = nums[0]
        for i in range(1, len(nums)):
            max_product, min_product = max(max_product * nums[i], min_product * nums[i], nums[i]), min(max_product * nums[i], min_product * nums[i], nums[i])
            ans = max(ans, max_product)
        return ans