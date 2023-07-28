class Solution:
    def minCut(self, s: str) -> int:
        
        # 1. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 2. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 3. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 4. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 5. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 6. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 7. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 8. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 9. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 10. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 11. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 12. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 13. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 14. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 15. dp[i] = min(dp[i], dp[j] + 1) if s[j:i] is palindrome
        # 16. s[j:i] is palindrome if s[j] == s[i-1] and s[j+1:i-1] is palindrome
        # 17. dp[i] = min(dp