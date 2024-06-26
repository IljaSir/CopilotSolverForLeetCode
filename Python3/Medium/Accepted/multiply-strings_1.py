class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        
        if num1 == "0" or num2 == "0":
            return "0"
        num1 = num1[::-1]
        num2 = num2[::-1]
        res = [0] * (len(num1) + len(num2))
        for i in range(len(num1)):
            for j in range(len(num2)):
                res[i+j] += int(num1[i]) * int(num2[j])
        for i in range(len(res)):
            if res[i] >= 10:
                res[i+1] += res[i] // 10
                res[i] = res[i] % 10
        res = res[::-1]
        while res[0] == 0:
            res.pop(0)
        return "".join([str(i) for i in res])