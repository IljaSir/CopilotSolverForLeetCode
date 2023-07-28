class Solution:
    def goodTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                for k in range(j+1, n):
                    if nums1[i] < nums1[j] < nums1[k] and nums2[i] < nums2[j] < nums2[k]:
                        res += 1
        return res