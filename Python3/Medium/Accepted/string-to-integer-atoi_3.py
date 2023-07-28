class Solution:
    def myAtoi(self, s: str) -> int:
        
        # 空字符串
        if not s:
            return 0
        # 去掉前后空格
        s = s.strip()
        # 字符串长度为0
        if len(s) == 0:
            return 0
        # 判断首字符是否为数字或者正负号
        if not s[0].isdigit() and s[0] != '-' and s[0] != '+':
            return 0
        # 判断正负号
        sign = 1
        if s[0] == '-':
            sign = -1
        # 判断首字符是否为数字
        if s[0].isdigit():
            result = int(s[0])
        else:
            result = 0
        # 遍历字符串
        for i in range(1, len(s)):
            if not s[i].isdigit():
                break
            result = result * 10 + int(s[i])
        # 判断是否越界
        result = result * sign
        if result < -2 ** 31:
            return -2 ** 31
        if result > 2 ** 31 - 1:
            return 2 ** 31 - 1
        return result