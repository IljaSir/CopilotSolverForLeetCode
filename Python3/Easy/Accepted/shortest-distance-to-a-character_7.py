class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        return [min([abs(i - j) for j, k in enumerate(s) if k == c]) for i, j in enumerate(s)]