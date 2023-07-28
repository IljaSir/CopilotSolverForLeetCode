class Solution:
    def minSwap(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        # dp[i][0] = min swaps to make nums1[:i+1] and nums2[:i+1] strictly increasing
        # if we swap nums1[i] and nums2[i]
        # dp[i][1] = min swaps to make nums1[:i+1] and nums2[:i+1] strictly increasing
        # if we don't swap nums1[i] and nums2[i]
        dp = [[n, n] for _ in range(n)]
        dp[0] = [0, 1]
        for i in range(1, n):
            if nums1[i] > nums1[i-1] and nums2[i] > nums2[i-1]:
                dp[i][0] = min(dp[i][0], dp[i-1][0]+1)
                dp[i][1] = min(dp[i][1], dp[i-1][1])
            if nums1[i] > nums2[i-1] and nums2[i] > nums1[i-1]:
                dp[i][0] = min(dp[i][0], dp[i-1][1]+1)
                dp[i][1] = min(dp[i][1], dp[i-1][0])
        return min(dp[-1])