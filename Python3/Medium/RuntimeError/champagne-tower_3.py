class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        glass = [[0 for _ in range(i + 1)] for i in range(100)]
        glass[0][0] = poured
        for i in range(query_row + 1):
            for j in range(len(glass[i])):
                if glass[i][j] > 1:
                    glass[i + 1][j] += (glass[i][j] - 1) / 2
                    glass[i + 1][j + 1] += (glass[i][j] - 1) / 2
                    glass[i][j] = 1
        return glass[query_row][query_glass]