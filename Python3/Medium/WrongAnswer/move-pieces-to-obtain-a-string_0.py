class Solution:
    def canChange(self, start: str, target: str) -> bool:
        
        for i in range(len(start)):
            if start[i] != target[i]:
                return True
        return False