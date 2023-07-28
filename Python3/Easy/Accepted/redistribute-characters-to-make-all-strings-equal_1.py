class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        count = {}
        for word in words:
            for c in word:
                count[c] = count.get(c, 0) + 1
        return all(v % len(words) == 0 for v in count.values())