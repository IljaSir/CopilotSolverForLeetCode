class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        
        count = 0
        odd = False
        d = {}
        for word in words:
            if word[0] == word[1]:
                count += 1
                continue
            if word[0] in d:
                d[word[0]] += 1
            else:
                d[word[0]] = 1
            if word[1] in d:
                d[word[1]] += 1
            else:
                d[word[1]] = 1
        for key, value in d.items():
            if value % 2 == 0:
                count += value
            else:
                count += value - 1
                odd = True
        if odd:
            count += 1
        return count