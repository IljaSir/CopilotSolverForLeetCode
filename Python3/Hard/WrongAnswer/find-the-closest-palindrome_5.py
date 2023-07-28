class Solution:
    def nearestPalindromic(self, n: str) -> str:
        
        n = int(n)
        candidates = set((str(x) for x in (10**len(str(n)) + 1, 10**(len(str(n))-1) - 1)))
        prefix = int(str(n)[:len(str(n))//2])
        for i in (-1, 0, 1):
            candidates.add(str(prefix + i) + str(prefix + i)[:(len(str(n)) % 2 == 0):][::-1])
        candidates.discard(str(n))
        return min(candidates, key=lambda x: (abs(int(x) - n), int(x)))