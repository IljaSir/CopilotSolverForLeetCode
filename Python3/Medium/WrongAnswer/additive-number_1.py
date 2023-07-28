class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        for i in range(1, len(num)):
            for j in range(i+1, len(num)):
                if num[0] == '0' and i > 1:
                    break
                if num[i] == '0' and j > i+1:
                    break
                a = int(num[:i])
                b = int(num[i:j])
                c = a + b
                k = j
                while k < len(num):
                    if num[k] == '0' and c > 0:
                        break
                    if num[k] != str(c)[0]:
                        break
                    if num[k:].startswith(str(c)):
                        a = b
                        b = c
                        c = a + b
                        k += len(str(c))
                    else:
                        break
                if k == len(num):
                    return True
        return False