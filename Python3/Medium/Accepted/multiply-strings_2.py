class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        
        if num1 == "0" or num2 == "0":
            return "0"
        res = 0
        for i in range(len(num1)):
            for j in range(len(num2)):
                res += int(num1[i]) * int(num2[j]) * 10 ** (len(num1) - i - 1) * 10 ** (len(num2) - j - 1)
        return str(res)