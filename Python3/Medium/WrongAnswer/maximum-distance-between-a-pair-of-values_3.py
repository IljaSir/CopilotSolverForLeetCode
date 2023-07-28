class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        
        res = 0
        for i in range(len(nums1)):
            if nums1[i] <= nums2[i]:
                res = max(res, i)
            else:
                break
        return res