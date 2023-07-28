class Solution:
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        
        # BFS
        # 1. convert 2D array to 1D array
        # 2. convert 1D array to string
        # 3. convert string to hash
        # 4. BFS
        # 5. convert hash to string
        # 6. convert string to 1D array
        # 7. convert 1D array to 2D array
        # 8. return 2D array
        # 9. return -1 if not found
        # Time  complexity: O(N!)
        # Space complexity: O(N!)
        # N = 6
        # 1. convert 2D array to 1D array
        board = [board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2]]
        # 2. convert 1D array to string
        string = ''.join(map(str, board))
        # 3. convert string to hash
        hash = int(string)
        # 4. BFS
        queue = collections.deque([hash])
        visited = set([hash])
        step = 0
        while queue:
            for _ in range(len(queue)):
                # 5. convert hash to string
                string = str(queue.popleft())
                # 6. convert string to 1D array
                board = list(map(int, string))
                # 7. convert 1D array to 2D array
                board = [[board[0], board[1], board[2]], [board[3], board[4], board[5]]]
                # 8. return 2D array
                if board == [[1,2,3],[4,5,0]]:
                    return step
                # 9. return -1 if not found
                zero = string.index('0')
                for move in (-1,1,3,-3):
                    if zero + move < 0 or zero + move > 5:
                        continue
                    if zero in (2,5) and move in (-1,1):
                        continue
                    tmp = list(string)
                    tmp[zero], tmp[zero+move] = tmp[zero+move], tmp[zero]
                    tmp = ''.join(tmp)
                    if