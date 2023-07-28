class Solution:
    def kthSmallestPath(self, destination: List[int], k: int) -> str:
        
        def nCr(n, r):
            f = math.factorial
            return f(n) // f(r) // f(n-r)
        
        def helper(m, n, k):
            if m == 0:
                return "V" * n
            if n == 0:
                return "H" * m
            if k <= nCr(m+n-1, n-1):
                return "H" + helper(m-1, n, k)
            else:
                return "V" + helper(m, n-1, k-nCr(m+n-1, n-1))
        return helper(destination[1], destination[0], k)