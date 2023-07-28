class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        for num in nums1:
            if num in nums2:
                return num
        return -1