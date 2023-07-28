class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        def helper(num1, num2, num):
            if not num:
                return True
            num3 = str(int(num1) + int(num2))
            if num.startswith(num3):
                return helper(num2, num3, num[len(num3):])
            return False
        for i in range(1, len(num)):
            for j in range(i+1, len(num)):
                if helper(num[:i], num[i:j], num[j:]):
                    return True
        return False