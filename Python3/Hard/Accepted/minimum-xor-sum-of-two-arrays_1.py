class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        n = len(nums1)
        @lru_cache(None)
        def dp(mask, i):
            if i == n:
                return 0
            res = float('inf')
            for j in range(n):
                if mask & (1 << j) == 0:
                    res = min(res, dp(mask | (1 << j), i + 1) + (nums1[i] ^ nums2[j]))
            return res
        return dp(0, 0)