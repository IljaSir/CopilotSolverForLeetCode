class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        
        c_indices = [i for i, x in enumerate(s) if x == c]
        return [min([abs(i - j) for j in c_indices]) for i in range(len(s))]