class Solution:
    def maximumGood(self, statements: List[List[int]]) -> int:
        
        n = len(statements)
        res = 0
        for i in range(n):
            for j in range(n):
                if statements[i][j] == 0:
                    statements[i][j] = -1
        for i in range(n):
            for j in range(n):
                if statements[i][j] == -1:
                    for k in range(n):
                        if statements[j][k] == 1:
                            statements[i][k] = 0
        for i in range(n):
            if statements[i].count(1) + statements[i].count(2) == n:
                res += 1
        return res