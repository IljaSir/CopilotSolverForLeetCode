class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        
        for i in range(len(words) - 1):
            if not self.isAlienSortedHelper(words[i], words[i + 1], order):
                return False
        return True