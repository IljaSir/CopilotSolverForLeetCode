class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        letters = {}
        for c in s:
            letters[c] = letters.get(c, 0) + 1
        max_length = 0
        for c in letters:
            max_length += letters[c] // 2 * 2
            if max_length % 2 == 0 and letters[c] % 2 == 1:
                max_length += 1
        return max_length