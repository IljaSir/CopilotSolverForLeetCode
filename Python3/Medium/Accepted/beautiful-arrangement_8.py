class Solution:
    def countArrangement(self, n: int) -> int:
        
        self.count = 0
        def backtrack(perm, i):
            if i == n:
                self.count += 1
                return
            for j in range(i, n):
                perm[i], perm[j] = perm[j], perm[i]
                if perm[i] % (i+1) == 0 or (i+1) % perm[i] == 0:
                    backtrack(perm, i+1)
                perm[i], perm[j] = perm[j], perm[i]
        backtrack([i for i in range(1, n+1)], 0)
        return self.count