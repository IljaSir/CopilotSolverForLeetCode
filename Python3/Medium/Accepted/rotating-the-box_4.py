class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        n = len(box)
        m = len(box[0])
        res = []
        for i in range(m):
            res.append([])
            for j in range(n):
                res[i].append('.')
        for i in range(n):
            j = m - 1
            while j >= 0:
                if box[i][j] == '#':
                    k = j
                    while k < m - 1 and res[k + 1][n - 1 - i] == '.':
                        k += 1
                    res[k][n - 1 - i] = '#'
                elif box[i][j] == '*':
                    res[j][n - 1 - i] = '*'
                j -= 1
        return res