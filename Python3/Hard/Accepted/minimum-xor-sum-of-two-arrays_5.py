class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        dp = [[float('inf') for _ in range(1<<n)] for _ in range(n)]
        def dfs(i: int, mask: int) -> int:
            if i == n:
                return 0
            if dp[i][mask] != float('inf'):
                return dp[i][mask]
            for j in range(n):
                if mask & (1<<j) == 0:
                    dp[i][mask] = min(dp[i][mask], dfs(i+1, mask|(1<<j)) + (nums1[i] ^ nums2[j]))
            return dp[i][mask]
        return dfs(0, 0)