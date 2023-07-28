class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        
        # Solution 1: Find the rook, then search in all 4 directions
        # Time  complexity: O(1)
        # Space complexity: O(1)
        # Find the rook
        rook_x = -1
        rook_y = -1
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == 'R':
                    rook_x = i
                    rook_y = j
                    break
            if rook_x != -1:
                break
        # Search in all 4 directions
        num_captures = 0
        for x, y in [(rook_x, rook_y+1), (rook_x+1, rook_y), (rook_x, rook_y-1), (rook_x-1, rook_y)]:
            while 0 <= x < 8 and 0 <= y < 8:
                if board[x][y] == 'B':
                    break
                elif board[x][y] == 'p':
                    num_captures += 1
                    break
                x += 1 if x < rook_x else -1 if x > rook_x else 0
                y += 1 if y < rook_y else -1 if y > rook_y else 0
        return num_captures