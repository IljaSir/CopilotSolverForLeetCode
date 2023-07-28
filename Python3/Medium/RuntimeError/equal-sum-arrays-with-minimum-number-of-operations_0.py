class Solution:
    def minOperations(self, nums1: List[int], nums2: List[int]) -> int:
        
        
        def get_sum(nums):
            return sum(nums)
        
        def get_diff(nums1, nums2):
            return abs(get_sum(nums1) - get_sum(nums2))
        
        def get_min_max(nums):
            return min(nums), max(nums)
        
        def get_min_max_diff(nums):
            return get_min_max(nums)[1] - get_min_max(nums)[0]
        
        def get_min_max_diff_sum(nums1, nums2):
            return get_min_max_diff(nums1) + get_min_max_diff(nums2)
        
        def get_min_max_diff_sum_sum(nums1, nums2):
            return get_min_max_diff_sum(nums1, nums2) + get_sum(nums1) + get_sum(nums2)
        
        def get_min_max_diff_sum_sum_diff(nums1, nums2):
            return get_min_max_diff_sum_sum(nums1, nums2) - get_diff(nums1, nums2)
        
        def get_min_max_diff_sum_sum_diff_sum(nums1, nums2):
            return get_min_max_diff_sum_sum_diff(nums1, nums2) + get_sum(nums1) + get_sum(nums2)
        
        def get_min_max_diff_sum_sum_diff_sum_diff(nums1, nums2):
            return get_min_max_diff_sum_sum_diff_sum(nums1, nums2) - get_diff(nums1, nums2)
        
        def get_min_max_diff_sum_sum_diff_sum_diff_sum(nums1, nums2):
            return get_min_max_diff_sum_sum_diff_sum_diff(nums1, nums2) + get_sum(nums1) + get_sum(nums2)
        
        def get_min_max_diff_sum_sum_diff_sum_diff_sum_diff(nums1, nums2):
            return get_min_max_diff_sum_sum_diff_sum_diff_sum(nums1, nums2) - get_diff(nums1, nums2)
        
        def get_min_max_diff_sum_sum_diff_sum_diff_sum_diff_sum(nums1, nums2):
            return get_min_max_diff_sum_sum_diff_sum_diff_sum_diff(nums1, nums2) + get_sum(nums1) + get_sum(nums2)
        
        def get_min_max_diff_sum_sum_diff_sum_diff_sum_diff_sum_diff(nums1, nums2):
            return get_min_max_diff_sum_sum_diff_sum_diff_sum_diff_sum(nums1, nums2) - get_diff(nums1, nums2)
        
        def get_min_max_diff_sum_sum_diff_sum_diff_sum_diff_sum_diff_sum(nums1, nums2):
            return