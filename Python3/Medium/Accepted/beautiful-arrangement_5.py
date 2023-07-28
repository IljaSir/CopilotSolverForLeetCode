class Solution:
    def countArrangement(self, n: int) -> int:
        
        def backtrack(i, n, used):
            if i > n:
                return 1
            res = 0
            for j in range(1, n+1):
                if j not in used and (j % i == 0 or i % j == 0):
                    used.add(j)
                    res += backtrack(i+1, n, used)
                    used.remove(j)
            return res
        return backtrack(1, n, set())