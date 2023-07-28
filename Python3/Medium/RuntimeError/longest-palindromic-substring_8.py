class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        # 1. 暴力法
        # 2. 动态规划
        # 3. 中心扩散法
        if len(s) < 2:
            return s
        start = 0
        end = 0
        for i in range(len(s)):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i + 1)
            max_len = max(len1, len2)
            if max_len > end - start:
                start = i - (max_len - 1) // 2
                end = i + max_len // 2
        return s[start:end + 1]