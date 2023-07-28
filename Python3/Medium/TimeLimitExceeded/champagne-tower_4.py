class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        if poured == 0:
            return 0
        if query_row == 0:
            return min(poured, 1)
        if query_glass == 0:
            return self.champagneTower(poured - 1, query_row - 1, query_glass) / 2
        if query_glass == query_row:
            return self.champagneTower(poured - 1, query_row - 1, query_glass - 1) / 2
        return self.champagneTower(poured - 1, query_row - 1, query_glass - 1) / 2 + self.champagneTower(poured - 1, query_row - 1, query_glass) / 2