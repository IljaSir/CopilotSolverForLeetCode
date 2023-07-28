class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        n = len(num)
        for i in range(1, min(11, n)):
            for j in range(i+1, min(i+11, n)):
                x, y = int(num[:i]), int(num[i:j])
                if x > 2**31-1 or y > 2**31-1:
                    break
                fib = [x, y]
                k = j
                while k < n:
                    z = fib[-1] + fib[-2]
                    if z > 2**31-1:
                        break
                    s = str(z)
                    if num[k:].startswith(s):
                        k += len(s)
                        fib.append(z)
                    else:
                        break
                if k == n and len(fib) > 2:
                    return fib
        return []