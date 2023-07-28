class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        if len(s) == 1:
            return s
        if len(s) == 2:
            if s[0] == s[1]:
                return s
            else:
                return s[0]
        # i is the center of the palindrome
        for i in range(len(s)):
            # j is the offset from the center
            for j in range(len(s)):
                # if the palindrome is odd
                if i - j >= 0 and i + j < len(s):
                    if s[i - j] == s[i + j]:
                        if j == 0:
                            continue
                        else:
                            continue
                    else:
                        break
                else:
                    break
            # if the palindrome is even
            for j in range(len(s)):
                if i - j >= 0 and i + j + 1 < len(s):
                    if s[i - j] == s[i + j + 1]:
                        if j == 0:
                            continue
                        else:
                            continue
                    else:
                        break
                else:
                    break
        return s[i - j + 1:i + j + 1]