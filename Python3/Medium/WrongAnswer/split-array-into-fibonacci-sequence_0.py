class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        n = len(num)
        for i in range(1, n):
            for j in range(i + 1, n):
                a, b = num[:i], num[i:j]
                if a != str(int(a)) or b != str(int(b)):
                    continue
                fib = [int(a), int(b)]
                while j < n:
                    c = str(fib[-1] + fib[-2])
                    if not num.startswith(c, j):
                        break
                    j += len(c)
                    fib.append(int(c))
                if j == n:
                    return fib
        return []