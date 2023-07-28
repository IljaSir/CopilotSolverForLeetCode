class Solution:
    def nextGreaterElement(self, n: int) -> int:
        
        s = list(str(n))
        i = len(s) - 1
        while i > 0 and s[i-1] >= s[i]:
            i -= 1
        if i == 0:
            return -1
        j = i
        while j < len(s) and s[j] > s[i-1]:
            j += 1
        s[i-1], s[j-1] = s[j-1], s[i-1]
        s[i:] = s[i:][::-1]
        res = int("".join(s))
        return res if res < 2**31 else -1