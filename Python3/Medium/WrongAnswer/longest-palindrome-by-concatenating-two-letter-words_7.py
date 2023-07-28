class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        result = 0
        odd = False
        for c in collections.Counter(''.join(words)).values():
            result += c // 2 * 2
            if not odd and c % 2 == 1:
                odd = True
                result += 1
        return result