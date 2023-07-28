class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        def dfs(num, index, num1, num2):
            if index == len(num):
                return True
            num3 = num1 + num2
            for i in range(1, len(num) - index + 1):
                if num[index] == '0' and i > 1:
                    return False
                if int(num[index:index + i]) == num3:
                    if dfs(num, index + i, num2, num3):
                        return True
            return False
        for i in range(1, len(num) // 2 + 1):
            for j in range(1, (len(num) - i) // 2 + 1):
                if num[0] == '0' and i > 1:
                    continue
                if num[i] == '0' and j > 1:
                    continue
                num1 = int(num[0:i])
                num2 = int(num[i:i + j])
                if dfs(num, i + j, num1, num2):
                    return True
        return False