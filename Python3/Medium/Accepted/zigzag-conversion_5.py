class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        n = len(s)
        step = 2 * numRows - 2
        ans = ''
        for i in range(numRows):
            for j in range(i, n, step):
                ans += s[j]
                if i != 0 and i != numRows - 1 and j + step - 2 * i < n:
                    ans += s[j + step - 2 * i]
        return ans