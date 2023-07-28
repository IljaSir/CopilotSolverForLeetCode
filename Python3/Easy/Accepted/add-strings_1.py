class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        
        num1 = num1[::-1]
        num2 = num2[::-1]
        result = ""
        carry = 0
        for i in range(max(len(num1), len(num2))):
            n1 = int(num1[i]) if i < len(num1) else 0
            n2 = int(num2[i]) if i < len(num2) else 0
            sum = n1 + n2 + carry
            carry = sum // 10
            result += str(sum % 10)
        if carry > 0:
            result += str(carry)
        return result[::-1]