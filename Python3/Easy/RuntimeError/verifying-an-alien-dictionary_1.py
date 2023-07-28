class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        
        if len(words) <= 1:
            return True
        for i in range(len(words) - 1):
            if not self.is_sorted(words[i], words[i + 1], order):
                return False
        return True