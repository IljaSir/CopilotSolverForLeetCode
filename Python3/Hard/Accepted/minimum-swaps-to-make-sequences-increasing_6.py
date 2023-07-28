class Solution:
    def minSwap(self, nums1: List[int], nums2: List[int]) -> int:
        
        N = len(nums1)
        swap = [N] * N
        keep = [N] * N
        keep[0] = 0
        swap[0] = 1
        for i in range(1, N):
            if nums1[i] > nums1[i-1] and nums2[i] > nums2[i-1]:
                keep[i] = keep[i-1]
                swap[i] = swap[i-1] + 1
            if nums2[i] > nums1[i-1] and nums1[i] > nums2[i-1]:
                keep[i] = min(keep[i], swap[i-1])
                swap[i] = min(swap[i], keep[i-1] + 1)
        return min(keep[N-1], swap[N-1])