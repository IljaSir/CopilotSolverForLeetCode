class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        nums2 = [(v, i) for i, v in enumerate(nums2)]
        nums2.sort()
        res = [None] * len(nums1)
        l, r = 0, len(nums1) - 1
        for v, i in nums2:
            if v < nums1[r]:
                res[i] = nums1[r]
                r -= 1
            else:
                res[i] = nums1[l]
                l += 1
        return res