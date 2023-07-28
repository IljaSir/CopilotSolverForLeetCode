class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        s_len = len(s)
        if s_len <= numRows:
            return s
        if numRows == 2:
            return s[::2] + s[1::2]
        # numRows >= 3
        res = ''
        for i in range(numRows):
            if i == 0 or i == numRows - 1:
                res += s[i::2 * numRows - 2]
            else:
                for j in range(i, s_len, 2 * numRows - 2):
                    res += s[j]
                    if j + 2 * numRows - 2 - 2 * i < s_len:
                        res += s[j + 2 * numRows - 2 - 2 * i]
        return res