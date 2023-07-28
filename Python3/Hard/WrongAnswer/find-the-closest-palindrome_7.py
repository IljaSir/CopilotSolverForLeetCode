class Solution:
    def nearestPalindromic(self, n: str) -> str:
        
        def isPalindromic(n):
            return n == n[::-1]
        def findClosest(n, candidates):
            candidates = sorted(candidates)
            diff = [abs(int(n) - int(c)) for c in candidates]
            min_diff = min(diff)
            return [candidates[i] for i in range(len(candidates)) if diff[i] == min_diff]
        candidates = set([str(10**len(n) + 1), str(10**(len(n)-1) - 1)])
        prefix = int(n[:(len(n)+1)//2])
        for i in range(-1, 2):
            candidates.add(str(prefix + i) + str(prefix + i)[:(len(n) % 2 == 0):][::-1])
        candidates.discard(n)
        return min(findClosest(n, candidates))