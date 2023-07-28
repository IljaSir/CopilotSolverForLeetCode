class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        
        i = 0
        while i < len(b):
            j = 0
            while i < len(b) and j < len(a) and a[j] == b[i]:
                i += 1
                j += 1
            if j == len(a):
                if i < len(b):
                    i -= j
                else:
                    return (len(b) + len(a) - 1) // len(a)
            i -= j
            i += 1
        return -1