class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        count = collections.Counter()
        for word in words:
            count += collections.Counter(word)
        return all(v % len(words) == 0 for v in count.values())