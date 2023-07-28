class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        
        return sum([1 for word in words if set(word).issubset(set(allowed))])