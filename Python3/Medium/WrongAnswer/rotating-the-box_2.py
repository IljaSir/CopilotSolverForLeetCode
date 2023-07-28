class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        m, n = len(box), len(box[0])
        res = [['.'] * m for _ in range(n)]
        for i in range(m):
            for j in range(n):
                if box[i][j] == '#':
                    res[j][m - 1 - i] = '#'
                elif box[i][j] == '*':
                    res[j][m - 1 - i] = '*'
        for i in range(n):
            for j in range(m - 1, -1, -1):
                if res[i][j] == '#':
                    for k in range(j + 1, m):
                        if res[i][k] == '.':
                            res[i][k], res[i][k - 1] = res[i][k - 1], res[i][k]
                        else:
                            break
        return res