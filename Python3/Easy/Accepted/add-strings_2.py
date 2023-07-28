class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        
        length1 = len(num1)
        length2 = len(num2)
        length = max(length1, length2)
        num1 = num1.zfill(length)
        num2 = num2.zfill(length)
        result = []
        carry = 0
        for i in range(length - 1, -1, -1):
            digit = int(num1[i]) + int(num2[i]) + carry
            carry = digit // 10
            digit %= 10
            result.append(str(digit))
        if carry:
            result.append(str(carry))
        return ''.join(result[::-1])