class Solution:
    def goodTriplets(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        ans = 0
        for i in range(n):
            for j in range(i+1, n):
                if abs(nums1[i] - nums1[j]) > abs(nums2[i] - nums2[j]):
                    continue
                for k in range(j+1, n):
                    if abs(nums1[i] - nums1[k]) > abs(nums2[i] - nums2[k]):
                        continue
                    if abs(nums1[j] - nums1[k]) > abs(nums2[j] - nums2[k]):
                        continue
                    ans += 1
        return ans