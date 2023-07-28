class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        
        # # 1st solution
        # # O(rowIndex^2) time | O(rowIndex^2) space
        # pascal = [[1] * (i + 1) for i in range(rowIndex + 1)]
        # for i in range(2, rowIndex + 1):
        #     for j in range(1, i):
        #         pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j]
        # return pascal[rowIndex]

        # 2nd solution
        # O(rowIndex^2) time | O(rowIndex) space
        pascal = [1] * (rowIndex + 1)
        for i in range(2, rowIndex + 1):
            prev = 1
            for j in range(1, i):
                curr = prev + pascal[j]
                prev = pascal[j]
                pascal[j] = curr
        return pascal