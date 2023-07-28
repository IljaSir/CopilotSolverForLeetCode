class Solution:
    def minOperations(self, s: str) -> int:
        
        return min(sum(s[i] != c for i, c in enumerate('01' * (len(s) // 2 + 1))) for c in '01')