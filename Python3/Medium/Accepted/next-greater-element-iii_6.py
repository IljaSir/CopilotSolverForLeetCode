class Solution:
    def nextGreaterElement(self, n: int) -> int:
        
        n = list(str(n))
        i = len(n) - 2
        while i >= 0 and n[i] >= n[i+1]:
            i -= 1
        if i < 0:
            return -1
        j = len(n) - 1
        while j >= 0 and n[j] <= n[i]:
            j -= 1
        n[i], n[j] = n[j], n[i]
        n[i+1:] = n[i+1:][::-1]
        n = int(''.join(n))
        if n > 2**31 - 1:
            return -1
        return n