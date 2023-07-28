class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        tower = [[0] * (i + 1) for i in range(100)]
        tower[0][0] = poured
        for i in range(query_row):
            for j in range(i + 1):
                if tower[i][j] > 1:
                    tower[i + 1][j] += (tower[i][j] - 1) / 2
                    tower[i + 1][j + 1] += (tower[i][j] - 1) / 2
                    tower[i][j] = 1
        return min(1, tower[query_row][query_glass])