class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            return s
        s_list = list(s)
        result = []
        for i in range(numRows):
            if i == 0 or i == numRows - 1:
                result.append(s_list[i::2*(numRows-1)])
            else:
                result.append(s_list[i::2*(numRows-1)])
                result.append(s_list[2*(numRows-1)-i::2*(numRows-1)])
        return "".join(["".join(i) for i in result])