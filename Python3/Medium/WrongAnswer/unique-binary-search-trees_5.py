class Solution:
    def numTrees(self, n: int) -> int:
        
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            return self.numTrees(n-1) * 2 + self.numTrees(n-2)