class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        if k == 1:
            return [[i] for i in range(1, n+1)]
        if k == n:
            return [[i for i in range(1, n+1)]]
        if k == n-1:
            return [[i for i in range(1, n)],[n]]
        return [[i]+j for i in range(1, n-k+2) for j in self.combine(i-1, k-1)]