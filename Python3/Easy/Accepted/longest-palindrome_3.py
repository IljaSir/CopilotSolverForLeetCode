class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        if not s:
            return 0
        if len(s) == 1:
            return 1
        count = {}
        for char in s:
            if char in count:
                count[char] += 1
            else:
                count[char] = 1
        result = 0
        has_odd = False
        for char in count:
            if count[char] % 2 == 0:
                result += count[char]
            else:
                has_odd = True
                result += count[char] - 1
        if has_odd:
            result += 1
        return result