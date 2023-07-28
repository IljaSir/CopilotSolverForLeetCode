class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        nums2 = [(n, i) for i, n in enumerate(nums2)]
        nums2.sort()
        ans = [0] * len(nums1)
        i, j = 0, len(nums1) - 1
        for n, idx in nums2:
            if n < nums1[-1]:
                ans[idx] = nums1[i]
                i += 1
            else:
                ans[idx] = nums1[j]
                j -= 1
        return ans