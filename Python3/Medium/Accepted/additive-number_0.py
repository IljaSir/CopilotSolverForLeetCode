class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        for i in range(1, len(num)):
            for j in range(i+1, len(num)):
                a, b = num[:i], num[i:j]
                if a != str(int(a)) or b != str(int(b)):
                    continue
                while j < len(num):
                    c = str(int(a) + int(b))
                    if not num.startswith(c, j):
                        break
                    j += len(c)
                    a, b = b, c
                if j == len(num):
                    return True
        return False