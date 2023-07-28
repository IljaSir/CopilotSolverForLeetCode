class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        
        if len(num1) < len(num2):
            num1, num2 = num2, num1
        num1 = num1[::-1]
        num2 = num2[::-1]
        carry = 0
        result = []
        for i in range(len(num2)):
            cur = int(num1[i]) + int(num2[i]) + carry
            carry = cur // 10
            result.append(str(cur % 10))
        for i in range(len(num2), len(num1)):
            cur = int(num1[i]) + carry
            carry = cur // 10
            result.append(str(cur % 10))
        if carry:
            result.append(str(carry))
        return ''.join(result[::-1])