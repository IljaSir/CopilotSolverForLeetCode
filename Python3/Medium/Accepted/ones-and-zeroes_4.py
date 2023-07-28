class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        
        
        @lru_cache(None)
        def dp(i, m, n):
            if i == len(strs):
                return 0
            zeros, ones = strs[i].count('0'), strs[i].count('1')
            if m >= zeros and n >= ones:
                return max(dp(i + 1, m - zeros, n - ones) + 1, dp(i + 1, m, n))
            else:
                return dp(i + 1, m, n)
        return dp(0, m, n)