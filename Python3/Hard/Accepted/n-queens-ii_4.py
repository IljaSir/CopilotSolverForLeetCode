class Solution:
    def totalNQueens(self, n: int) -> int:
        
        def backtrack(queens: List[int], xy_diff: List[int], xy_sum: List[int]) -> int:
            p = len(queens)
            if p == n:
                return 1
            count = 0
            for q in range(n):
                if q not in queens and p - q not in xy_diff and p + q not in xy_sum:
                    count += backtrack(queens + [q], xy_diff + [p - q], xy_sum + [p + q])
            return count
        return backtrack([], [], [])