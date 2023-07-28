class Solution:
    def nextGreaterElement(self, n: int) -> int:
        
        # find the first decreasing digit
        s = list(str(n))
        i = len(s) - 2
        while i >= 0 and s[i] >= s[i+1]:
            i -= 1
        if i < 0:
            return -1
        # find the first digit that is larger than s[i]
        j = len(s) - 1
        while j > i and s[j] <= s[i]:
            j -= 1
        # swap s[i] and s[j]
        s[i], s[j] = s[j], s[i]
        # reverse s[i+1:]
        s[i+1:] = reversed(s[i+1:])
        res = int(''.join(s))
        return res if res < 2**31 else -1