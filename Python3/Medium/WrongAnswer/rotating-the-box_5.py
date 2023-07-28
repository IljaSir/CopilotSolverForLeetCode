class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        n, m = len(box), len(box[0])
        for i in range(n):
            box[i].reverse()
            j = 0
            while j < m:
                if box[i][j] == '#':
                    k = j
                    while k < m and box[i][k] != '*':
                        k += 1
                    if k == m:
                        box[i][j:k] = ['.'] * (k - j)
                    else:
                        box[i][j:k - 1] = ['.'] * (k - j - 1)
                        box[i][k - 1] = '#'
                    j = k
                else:
                    j += 1
        return list(zip(*box))