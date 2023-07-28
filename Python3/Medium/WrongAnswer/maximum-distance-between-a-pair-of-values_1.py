class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        
        n, m = len(nums1), len(nums2)
        res = 0
        j = m - 1
        for i in range(n):
            while j > i and nums1[i] > nums2[j]:
                j -= 1
            if j == i and nums1[i] > nums2[j]:
                break
            res = max(res, j - i)
        return res