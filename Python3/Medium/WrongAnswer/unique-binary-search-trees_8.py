class Solution:
    def numTrees(self, n: int) -> int:
        
        # Catalan number
        return (math.factorial(2*n)//(math.factorial(n+1)*math.factorial(n)))%(10**9+7)