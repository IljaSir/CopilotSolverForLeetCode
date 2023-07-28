class Solution:
    def judgeCircle(self, moves: str) -> bool:
        
        if len(moves) % 2 != 0:
            return False
        else:
            return moves.count('U') == moves.count('D') and moves.count('L') == moves.count('R')