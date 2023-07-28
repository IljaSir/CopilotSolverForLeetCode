class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        res = 0
        for word in words:
            i = 0
            for c in s:
                if i < len(word) and word[i] == c:
                    i += 1
            if i == len(word):
                res += 1
        return res