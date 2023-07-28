class Solution:
    def nearestPalindromic(self, n: str) -> str:
        
        n = int(n)
        candidates = set((str(10**i + d) for i in (len(str(n)), len(str(n))+1) for d in (-1, 1)))
        candidates |= set((str(n//10**i + d) + str(n//10**i + d)[:i][::-1]) for i in range(1, len(str(n))) for d in (-1, 1))
        candidates.discard(str(n))
        return min(candidates, key=lambda x: (abs(int(x) - n), int(x)))