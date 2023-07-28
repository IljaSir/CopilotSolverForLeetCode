class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if len(s) == 0:
            return ""
        if len(s) == 1:
            return s
        max_len = 1
        start = 0
        for i in range(1, len(s)):
            low = i - 1
            high = i
            while low >= 0 and high < len(s) and s[low] == s[high]:
                if high - low + 1 > max_len:
                    max_len = high - low + 1
                    start = low
                low -= 1
                high += 1
            low = i - 1
            high = i + 1
            while low >= 0 and high < len(s) and s[low] == s[high]:
                if high - low + 1 > max_len:
                    max_len = high - low + 1
                    start = low
                low -= 1
                high += 1
        return s[start:start + max_len]