class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        
        # row = [1]
        # for i in range(1, rowIndex + 1):
        #     row.append(row[i - 1] * (rowIndex - i + 1) // i)
        # return row
        row = [1] * (rowIndex + 1)
        for i in range(1, rowIndex + 1):
            for j in range(i - 1, 0, -1):
                row[j] += row[j - 1]
        return row