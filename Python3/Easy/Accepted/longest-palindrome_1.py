class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        char_dict = {}
        for char in s:
            if char not in char_dict:
                char_dict[char] = 1
            else:
                char_dict[char] += 1
        odd_count = 0
        for char, count in char_dict.items():
            if count % 2 == 1:
                odd_count += 1
        if odd_count == 0:
            return len(s)
        else:
            return len(s) - odd_count + 1