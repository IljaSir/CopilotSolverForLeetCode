class Solution:
    def minAbsoluteSumDiff(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        abs_diff = [abs(nums1[i] - nums2[i]) for i in range(n)]
        s = sum(abs_diff)
        max_diff = 0
        nums1.sort()
        for diff, num1, num2 in zip(abs_diff, nums1, nums2):
            i = bisect.bisect_left(nums1, num2)
            if i < n:
                max_diff = max(max_diff, diff - abs(nums1[i] - num2))
            if i > 0:
                max_diff = max(max_diff, diff - abs(nums1[i-1] - num2))
        return (s - max_diff) % (10**9 + 7)