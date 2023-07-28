class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        n = len(nums1)
        res = [-1] * n
        for i in range(n):
            lo, hi = 0, n - 1
            while lo < hi:
                mid = lo + (hi - lo) // 2
                if nums1[mid] > nums2[i]:
                    hi = mid
                else:
                    lo = mid + 1
            if nums1[lo] > nums2[i]:
                res[i] = nums1[lo]
                nums1.pop(lo)
            else:
                res[i] = nums1[0]
                nums1.pop(0)
        return res