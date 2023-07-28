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
                    if k != j:
                        box[i][j], box[i][k] = '.', '#'
                j -= 1
        ans = [['.' for _ in range(m)] for _ in range(n)]
        for i in range(m):
            for j in range(n):
                ans[j][m - 1 - i] = box[i][j]
        return ans