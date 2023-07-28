class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        for i in range(len(nums1)):
            if nums1[i] in nums2:
                return nums1[i]
        return -1