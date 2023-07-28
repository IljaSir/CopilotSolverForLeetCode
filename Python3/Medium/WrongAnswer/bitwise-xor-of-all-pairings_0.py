class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        
        def get_min_xor(nums):
            res = 0
            for num in nums:
                res ^= num
            return res
        def get_max_xor(nums):
            res = 0
            for num in nums:
                res ^= num
            return res
        min_xor = get_min_xor(nums1)
        max_xor = get_max_xor(nums1)
        res = 0
        for num in nums2:
            if min_xor ^ num <= max_xor ^ num:
                res ^= min_xor ^ num
            else:
                res ^= max_xor ^ num
        return res