class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        char_counts = {}
        for char in s:
            if char not in char_counts:
                char_counts[char] = 1
            else:
                char_counts[char] += 1
        odd_count = 0
        for char in char_counts:
            if char_counts[char] % 2 == 1:
                odd_count += 1
        if odd_count == 0:
            return len(s)
        return len(s) - odd_count + 1