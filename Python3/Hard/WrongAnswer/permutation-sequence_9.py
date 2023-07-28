class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        
        k -= 1
        r = n-1
        f = 1
        for i in range(2, n): f *= i
        r = k // f
        k %= f
        r = str(r+1)
        for i in range(2, n+1):
            if i == int(r): continue
            r += str(i)
        for i in range(n-2, 0, -1):
            f //= i+1
            r = r[:i] + r[i:i+1] + r[i+1:].replace(r[i], '', k//f)
            k %= f
        return r