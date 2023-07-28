class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        
        return self.backspace_helper(s) == self.backspace_helper(t)