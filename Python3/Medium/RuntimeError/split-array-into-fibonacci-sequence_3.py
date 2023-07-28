class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        n = len(num)
        if n < 3: return []
        for i in range(n):
            if i > 0 and num[0] == '0': break
            for j in range(i+1, n):
                if j > i+1 and num[i+1] == '0': break
                a, b = int(num[:i+1]), int(num[i+1:j+1])
                c = a+b
                fib = [a, b, c]
                while len(num) > j+1:
                    j += 1
                    c = str(c)
                    if j+len(c) > n or num[j:j+len(c)] != c: break
                    j += len(c)-1
                    fib.append(int(c))
                    a, b = b, c
                    c = a+b
                if len(num) == j+1: return fib
        return []