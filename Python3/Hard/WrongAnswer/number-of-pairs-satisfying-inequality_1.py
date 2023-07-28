class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], diff: int) -> int:
        
        nums1.sort()
        nums2.sort()
        i = 0
        j = 0
        res = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] - nums2[j] > diff:
                j += 1
            elif nums1[i] - nums2[j] <= diff:
                res += j
                i += 1
        return res