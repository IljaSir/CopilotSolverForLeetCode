class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        if len(num) < 3:
            return False
        for i in range(1, len(num) // 2 + 1):
            for j in range(1, len(num) // 2 + 1):
                if num[0] == '0' and i > 1:
                    continue
                if num[i] == '0' and j > 1:
                    continue
                a = num[:i]
                b = num[i:i + j]
                c = str(int(a) + int(b))
                k = i + j
                while k + len(c) <= len(num):
                    if num[k:k + len(c)] != c:
                        break
                    a = b
                    b = c
                    c = str(int(a) + int(b))
                    k += len(c)
                if k == len(num):
                    return True
        return False