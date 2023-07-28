class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        dp = [[0] * (1 << n) for _ in range(n)]
        for i in range(n):
            for j in range(1 << n):
                if j & (1 << i):
                    dp[i][j] = dp[i][j ^ (1 << i)] + (nums1[i] ^ nums2[i])
                    for k in range(n):
                        if j & (1 << k):
                            dp[i][j] = min(dp[i][j], dp[k][j ^ (1 << i)] + (nums1[i] ^ nums2[k]))
        return dp[n - 1][(1 << n) - 1]