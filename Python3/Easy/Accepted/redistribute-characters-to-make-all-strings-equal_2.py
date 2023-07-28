class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        count = {}
        for w in words:
            for c in w:
                count[c] = count.get(c, 0) + 1
        return all(v % len(words) == 0 for v in count.values())