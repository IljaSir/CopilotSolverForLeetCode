class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        
        res = ''
        for word in dictionary:
            i = 0
            for c in s:
                if i < len(word) and c == word[i]:
                    i += 1
            if i == len(word) and len(word) >= len(res):
                if len(word) > len(res) or res > word:
                    res = word
        return res