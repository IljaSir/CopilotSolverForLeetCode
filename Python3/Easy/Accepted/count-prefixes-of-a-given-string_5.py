class Solution:
    def countPrefixes(self, words: List[str], s: str) -> int:
        
        return sum(map(lambda x: s.startswith(x), words))