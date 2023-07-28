class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        ans = 0
        for word in words:
            i = 0
            for c in s:
                if i < len(word) and c == word[i]:
                    i += 1
            if i == len(word):
                ans += 1
        return ans