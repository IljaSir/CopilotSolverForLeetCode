class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        m, n = len(box), len(box[0])
        for i in range(m):
            for j in range(n):
                if box[i][j] == '#':
                    k = j
                    while k + 1 < n and box[i][k + 1] == '.':
                        k += 1
                    if k != j:
                        box[i][k] = '#'
                        box[i][j] = '.'
        return list(map(list, zip(*box)))[::-1]