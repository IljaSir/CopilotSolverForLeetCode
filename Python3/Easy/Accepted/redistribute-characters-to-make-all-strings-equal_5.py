class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        counts = collections.Counter(c for word in words for c in word)
        return all(v % len(words) == 0 for v in counts.values())