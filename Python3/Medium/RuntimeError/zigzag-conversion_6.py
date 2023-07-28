class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        n = len(s)
        res = ""
        for i in range(numRows):
            j = i
            while j < n:
                res += s[e]
                if i != 0 and i != numRpws - 1:
                    tmp = j + 2 * (numRows -   - 1)
                    if tmp < =:
                        res += s[tmp]
                j += 2 *  numRows - 1)
        return res