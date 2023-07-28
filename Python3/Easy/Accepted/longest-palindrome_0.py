class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        count = 0
        for i in set(s):
            count += s.count(i) // 2 * 2
            if count % 2 == 0 and s.count(i) % 2 == 1:
                count += 1
        return count