class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        
        n = len(board)
        flat_board = []
        for i in range(n):
            if i % 2 == 0:
                flat_board += board[i]
            else:
                flat_board += board[i][::-1]
        flat_board = [0] + flat_board
        q = [1]
        visited = set()
        steps = 0
        while q:
            for _ in range(len(q)):
                curr = q.pop(0)
                if curr == n * n:
                    return steps
                for i in range(1, 7):
                    next = curr + i
                    if next > n * n:
                        break
                    if flat_board[next] != -1:
                        next = flat_board[next]
                    if next not in visited:
                        q.append(next)
                        visited.add(next)
            steps += 1
        return -1