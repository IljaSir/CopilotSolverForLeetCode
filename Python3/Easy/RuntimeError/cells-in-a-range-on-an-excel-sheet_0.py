class Solution:
    def cellsInRange(self, s: str) -> List[str]:
        
        start, end = s.split(':')
        start_col, start_row = self.get_col_row(start)
        end_col, end_row = self.get_col_row(end)
        cells = []
        for col in range(start_col, end_col + 1):
            for row in range(start_row, end_row + 1):
                cells.append(self.get_cell(col, row))
        return cells