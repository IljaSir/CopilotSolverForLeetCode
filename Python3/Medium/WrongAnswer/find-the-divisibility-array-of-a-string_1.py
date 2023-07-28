class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        
        res = [0] * len(word)
        for i, c in enumerate(word):
            res[i] = 1 if int(c) % m == 0 else 0
        return res