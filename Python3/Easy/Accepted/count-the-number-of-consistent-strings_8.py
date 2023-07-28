class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        
        # 1st solution
        # return sum(all(c in allowed for c in word) for word in words)
        # 2nd solution
        # return sum(set(word).issubset(set(allowed)) for word in words)
        # 3rd solution
        return sum(all(c in allowed for c in word) for word in words)