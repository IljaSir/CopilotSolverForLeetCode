class Solution:
    def nextGreaterElement(self, n: int) -> int:
        
        if n < 10:
            return -1
        n = list(str(n))
        i = len(n) - 2
        while i >= 0 and n[i] >= n[i+1]:
            i -= 1
        if i == -1:
            return -1
        j = i+1
        while j < len(n) and n[j] > n[i]:
            j += 1
        n[i], n[j-1] = n[j-1], n[i]
        n[i+1:] = reversed(n[i+1:])
        res = int(''.join(n))
        return res if res < 2**31 else -1