class Solution:
    def minimumMoves(self, s: str) -> int:
        
        # convert all 'X' to 'O'
        # return the minimum number of moves required
        # if s[i] == 'X':
        #     s[i] = 'O'
        #     s[i+1] = 'O'
        #     s[i+2] = 'O'
        #     i += 3
        # else:
        #     i += 1
        # return moves
        moves = 0
        i = 0
        while i < len(s):
            if s[i] == 'X':
                moves += 1
                i += 3
            else:
                i += 1
        return moves