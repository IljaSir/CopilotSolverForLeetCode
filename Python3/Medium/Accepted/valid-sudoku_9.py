class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        def check(s):
            s = [x for x in s if x != '.']
            return len(s) == len(set(s))
        for i in range(9):
            if not check(board[i]) or not check([board[j][i] for j in range(9)]):
                return False
        for i in range(3):
            for j in range(3):
                if not check([board[x][y] for x in range(i*3, i*3+3) for y in range(j*3, j*3+3)]):
                    return False
        return True