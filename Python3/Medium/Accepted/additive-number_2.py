class Solution:
    def isAdditiveNumber(self, num: str) -> bool:
        
        n = len(num)
        for i in range(1, n):
            for j in range(i+1, n):
                if num[0] == '0' and i > 1:
                    break
                if num[i] == '0' and j > i+1:
                    break
                a, b = int(num[:i]), int(num[i:j])
                while j < n:
                    c = a + b
                    if not num.startswith(str(c), j):
                        break
                    j += len(str(c))
                    a, b = b, c
                if j == n:
                    return True
        return False