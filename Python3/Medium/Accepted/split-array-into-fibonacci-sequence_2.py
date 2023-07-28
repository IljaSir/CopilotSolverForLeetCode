class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        if not num:
            return []
        if len(num) < 3:
            return []
        for i in range(1, len(num)):
            for j in range(i+1, len(num)):
                if num[0] == '0' and i > 1:
                    break
                if num[i] == '0' and j > i+1:
                    break
                if int(num[0:i]) > 2**31-1:
                    break
                if int(num[i:j]) > 2**31-1:
                    break
                a, b = int(num[0:i]), int(num[i:j])
                fibs = [a, b]
                while len(num) > j:
                    c = a+b
                    if c > 2**31-1:
                        break
                    fibs.append(c)
                    a, b = b, c
                    c = str(c)
                    if not num.startswith(c, j):
                        break
                    j += len(c)
                if j == len(num):
                    return fibs
        return []