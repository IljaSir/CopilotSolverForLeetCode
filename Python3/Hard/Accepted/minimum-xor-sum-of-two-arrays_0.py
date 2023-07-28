class Solution:
    def minimumXORSum(self, nums1: List[int], nums2: List[int]) -> int:
        
        
        @lru_cache(None)
        def dp(i, mask):
            if i == len(nums1):
                return 0
            res = float('inf')
            for j in range(len(nums2)):
                if mask & (1 << j):
                    continue
                res = min(res, dp(i + 1, mask | (1 << j)) + (nums1[i] ^ nums2[j]))
            return res
        
        return dp(0, 0)