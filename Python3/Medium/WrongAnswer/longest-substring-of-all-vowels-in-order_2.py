class Solution:
    def longestBeautifulSubstring(self, word: str) -> int:
        
        # https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/discuss/1110486/Python-O(n)-solution
        vowels = 'aeiou'
        res = 0
        for i in range(len(word)):
            if word[i] == 'a':
                j = i
                while j < len(word) and word[j] in vowels:
                    j += 1
                if word[j-1] == 'u':
                    res = max(res, j-i)
        return res