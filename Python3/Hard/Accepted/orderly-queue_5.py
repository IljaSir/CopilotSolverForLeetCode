class Solution:
    def orderlyQueue(self, s: str, k: int) -> str:
        
        # if k > 1, we can reorder the string, so just sort it
        if k > 1:
            return ''.join(sorted(s))
        # else, we can only move the first character to the end
        # so we try all possible moves to find the lexicographically smallest string
        return min(s[i:]+s[:i] for i in range(len(s)))