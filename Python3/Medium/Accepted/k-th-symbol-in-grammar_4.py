class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        
        # n = 2, k = 2
        # n = 3, k = 2
        # n = 4, k = 2
        # n = 5, k = 2
        # n = 6, k = 2
        # n = 7, k = 2
        # n = 8, k = 2
        if n == 1:
            return 0
        if k % 2 == 0:
            return 1 - self.kthGrammar(n-1, k//2)
        else:
            return self.kthGrammar(n-1, (k+1)//2)