class Solution:
    def nearestPalindromic(self, n: str) -> str:
        
        candidates = set()
        l = len(n)
        candidates.add(10**l + 1)
        candidates.add(10**(l-1) - 1)
        prefix = int(n[:(l+1)//2])
        for i in (prefix - 1, prefix, prefix + 1):
            candidates.add(str(i) + str(i)[:(l+1)//2][::-1])
        candidates.discard(n)
        return str(min(candidates, key=lambda x: (abs(int(x) - int(n)), int(x))))