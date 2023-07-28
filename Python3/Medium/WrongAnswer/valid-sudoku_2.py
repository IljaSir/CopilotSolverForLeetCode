class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        seen = set()
        for i, row in enumerate(board):
            for j, c in enumerate(row):
                if c != '.':
                    seen.add((c, i))
                    seen.add((j, c))
                    seen.add((i//3, j//3, c))
        return len(seen) == 3*9