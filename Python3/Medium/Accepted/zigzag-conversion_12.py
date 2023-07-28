class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        s_list = list(s)
        n = len(s_list)
        res = []
        for i in range(numRows):
            j = i
            while j < n:
                res.append(s_list[j])
                j += 2 * (numRows - 1)
                if i != 0 and i != numRows - 1 and j - 2 * i < n:
                    res.append(s_list[j - 2 * i])
        return "".join(res)