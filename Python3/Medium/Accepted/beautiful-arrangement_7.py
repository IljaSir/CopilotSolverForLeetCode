class Solution:
    def countArrangement(self, n: int) -> int:
        
        def backtrack(i, n, visited):
            if i > n:
                return 1
            count = 0
            for j in range(1, n+1):
                if visited[j] == 0 and (i % j == 0 or j % i == 0):
                    visited[j] = 1
                    count += backtrack(i+1, n, visited)
                    visited[j] = 0
            return count
        return backtrack(1, n, [0]*(n+1))