class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        if k == 1:
            return [[i] for i in range(1, n+1)]
        elif n == k:
            return [[i for i in range(1, n+1)]]
        else:
            return [ [n] + comb for comb in self.combine(n-1, k-1) ] + self.combine(n-1, k)