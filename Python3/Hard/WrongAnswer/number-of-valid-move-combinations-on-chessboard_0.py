class Solution:
    def countCombinations(self, pieces: List[str], positions: List[List[int]]) -> int:
        
        n = len(pieces)
        ans = 0
        def dfs(pos, i):
            nonlocal ans
            if i == n:
                ans += 1
                return
            for r in range(1, 9):
                for c in range(1, 9):
                    if pos[i] == [r, c]:
                        continue
                    if pieces[i] == 'rook':
                        if r != pos[i][0] and c != pos[i][1]:
                            continue
                    if pieces[i] == 'bishop':
                        if abs(r - pos[i][0]) != abs(c - pos[i][1]):
                            continue
                    dfs(pos + [[r, c]], i + 1)
        dfs(positions, 0)
        return ans