class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        # # Solution 1: Brute Force
        # # Time complexity: O(n^3)
        # # Space complexity: O(1)
        # n = len(s)
        # longest = ""
        # for i in range(n):
        #     for j in range(i, n):
        #         if self.isPalindrome(s[i:j+1]) and len(s[i:j+1]) > len(longest):
        #             longest = s[i:j+1]
        # return longest

        # # Solution 2: Dynamic Programming
        # # Time complexity: O(n^2)
        # # Space complexity: O(n^2)
        # longest = ""
        # n = len(s)
        # dp = [[False for _ in range(n)] for _ in range(n)]
        # for i in range(n):
        #     dp[i][i] = True
        #     longest = s[i]
        # for i in range(n-1):
        #     if s[i] == s[i+1]:
        #         dp[i][i+1] = True
        #         longest = s[i:i+2]
        # for l in range(3, n+1):
        #     for i in range(n-l+1):
        #         j = i + l - 1
        #         if dp[i+1][j-1] and s[i] == s[j]:
        #             dp[i][j] = True
        #             longest = s[i:j+1]
        # return longest

        # Solution 3: Expand Around Center
        # Time complexity: O(n^2)
        # Space complexity: O(1)
        start = 0
        end = 0
        n = len(s)
        for i in range(n):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i+1)
            max_len = max(len1, len2)
            if max_len > end - start + 1:
                start = i - (max_len - 1)//2
                end = i + max_len//2
        return s[start:end+1]