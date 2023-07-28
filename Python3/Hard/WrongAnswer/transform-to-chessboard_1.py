class Solution:
    def movesToChessboard(self, board: List[List[int]]) -> int:
        
        N = len(board)
        # Check if the board is valid
        for row in board:
            if row[0] != board[0][0]:
                row.reverse()
            if row != board[0]:
                return -1
        # Count the number of ones and zeros
        count = sum(board[0])
        # Count the number of swaps needed to make the first row valid
        swaps = sum([board[0][i] == i % 2 for i in range(N)])
        # If N is even, the number of ones and zeros must be equal
        if N % 2 == 0:
            if count != N // 2:
                return -1
            # If the number of swaps is odd, we need to swap the first row
            if swaps % 2 == 1:
                swaps = N - swaps
        # If N is odd, the number of ones and zeros must be different by 1
        else:
            if count not in (N // 2, N // 2 + 1):
                return -1
            # If the number of ones is greater than the number of zeros, the first row should start with 1
            if count > N // 2:
                if swaps % 2 == 1:
                    swaps = N - swaps
            # If the number of zeros is greater than the number of ones, the first row should start with 0
            else:
                if swaps % 2 == 0:
                    swaps = N - swaps
        # The number of swaps needed to make the first column valid is half the number of swaps needed to make the first row valid
        return (swaps + 1) // 2