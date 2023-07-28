class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        
        return [word for word in words if any(word in w for w in words if w != word)]