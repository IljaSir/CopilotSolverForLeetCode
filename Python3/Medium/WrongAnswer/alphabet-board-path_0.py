class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        
        board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]
        board_dict = {}
        for i, row in enumerate(board):
            for j, char in enumerate(row):
                board_dict[char] = (i, j)
        ans = []
        prev = (0, 0)
        for char in target:
            x, y = board_dict[char]
            if x > prev[0]:
                ans.append('D' * (x - prev[0]))
            elif x < prev[0]:
                ans.append('U' * (prev[0] - x))
            if y > prev[1]:
                ans.append('R' * (y - prev[1]))
            elif y < prev[1]:
                ans.append('L' * (prev[1] - y))
            ans.append('!')
            prev = (x, y)
        return ''.join(ans)