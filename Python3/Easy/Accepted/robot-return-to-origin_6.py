class Solution:
    def judgeCircle(self, moves: str) -> bool:
        
        # 1st solution
        # Runtime: 40 ms, faster than 98.39% of Python3 online submissions for Robot Return to Origin.
        # Memory Usage: 14.5 MB, less than 5.10% of Python3 online submissions for Robot Return to Origin.
        # return moves.count('U') == moves.count('D') and moves.count('L') == moves.count('R')
        # 2nd solution
        # Runtime: 44 ms, faster than 87.33% of Python3 online submissions for Robot Return to Origin.
        # Memory Usage: 14.4 MB, less than 5.10% of Python3 online submissions for Robot Return to Origin.
        return not (moves.count('U') - moves.count('D') or moves.count('L') - moves.count('R'))
        # 3rd solution
        # Runtime: 40 ms, faster than 98.39% of Python3 online submissions for Robot Return to Origin.
        # Memory Usage: 14.4 MB, less than 5.10% of Python3 online submissions for Robot Return to Origin.
        # return not (collections.Counter(moves)['U'] - collections.Counter(moves)['D'] or collections.Counter(moves)['L'] - collections.Counter(moves)['R'])
        # 4th solution
        # Runtime: 44 ms, faster than 87.33% of Python3 online submissions for Robot Return to Origin.
        # Memory Usage: 14.4 MB, less than 5.10% of Python3 online submissions for Robot Return to Origin.
        # return not (collections.Counter(moves)['U'] - collections.Counter(moves)['D'] or collections.Counter(moves)['L'] - collections.Counter(moves)['R'])
        # 5th solution
        # Runtime: 44 ms, faster than 87.33% of Python3 online submissions for Robot Return to Origin.
        # Memory Usage: 14.4 MB, less than 5.10% of Python3 online submissions for Robot Return to Origin.
        # return not (collections.Counter(moves)['U'] - collections.Counter(moves)['D'] or collections.Counter(moves)['L'] - collections.Counter(moves)['R'])
        # 6th solution
        # Runtime: 44 ms, faster than 87.33% of Python3 online submissions for