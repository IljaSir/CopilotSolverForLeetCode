class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        
        count = 0
        for w in words:
            if w in s:
                count += 1
        return count