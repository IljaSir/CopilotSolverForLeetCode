class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        
        # 26进制转换
        # 从右往左，每次取余数
        # 余数+64得到字符
        # 余数为0时，需要向左取1位，同时余数为26
        # 余数为0时，需要向左取1位，同时余数为26
        res = ''
        while columnNumber > 0:
            columnNumber, remainder = divmod(columnNumber, 26)
            if remainder == 0:
                columnNumber -= 1
                remainder = 26
            res = chr(remainder + 64) + res
        return res