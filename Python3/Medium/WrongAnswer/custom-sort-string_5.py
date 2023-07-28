class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        order = order[::-1]
        for c in order:
            s = s.replace(c, '')
        return s + order