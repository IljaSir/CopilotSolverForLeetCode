class Solution:
    def appealSum(self, s: str) -> int:
        
        count = 0
        for i in range(1, len(s)+1):
            count += len(set(s[:i]))
        return count