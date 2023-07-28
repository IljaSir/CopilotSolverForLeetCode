class Solution:
    def goodTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if nums1[j] > nums1[i]:
                    for k in range(j+1, n):
                        if nums1[k] > nums1[j] and nums2[k] > nums2[j] and nums2[j] > nums2[i]:
                            ans += 1
        return ans