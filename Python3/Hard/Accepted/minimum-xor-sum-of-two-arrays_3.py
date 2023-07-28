class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        @lru_cache(None)
        def dfs(i, mask):
            if i == n:
                return 0
            ans = float("inf")
            for j in range(n):
                if mask & (1 << j) == 0:
                    ans = min(ans, (nums1[i] ^ nums2[j]) + dfs(i + 1, mask | (1 << j)))
            return ans
        return dfs(0, 0)