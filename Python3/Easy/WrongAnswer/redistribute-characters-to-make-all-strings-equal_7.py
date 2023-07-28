class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        
        return len(set([len(w) for w in words])) == 1