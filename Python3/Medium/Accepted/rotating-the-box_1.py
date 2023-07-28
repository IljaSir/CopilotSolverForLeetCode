class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        m, n = len(box), len(box[0])
        for i in range(m):
            j = n - 1
            while j >= 0:
                if box[i][j] == '#':
                    k = j + 1
                    while k < n and box[i][k] == '.':
                        k += 1
                    k -= 1
                    if k > j:
                        box[i][k] = '#'
                        box[i][j] = '.'
                j -= 1
        return list(zip(*box[::-1]))