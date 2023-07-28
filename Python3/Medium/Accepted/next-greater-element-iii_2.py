class Solution:
    def nextGreaterElement(self, n: int) -> int:
        
        s = list(str(n))
        i = j = len(s)-1
        while i > 0 and s[i-1] >= s[i]:
            i -= 1
        if i == 0:
            return -1
        k = i - 1
        while s[j] <= s[k]:
            j -= 1
        s[k], s[j] = s[j], s[k]
        l, r = k+1, len(s)-1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l, r = l+1, r-1
        res = int(''.join(s))
        return res if res < 2**31 else -1