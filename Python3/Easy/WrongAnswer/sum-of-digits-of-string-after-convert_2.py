class Solution:
    def getLucky(self, s: str, k: int) -> int:
        
        # convert s to n
        n = 0
        for c in s:
            n = 10 * n + ord(c) - ord('a') + 1
        # transform n to n'
        for _ in range(k):
            n = sum(map(int, str(n)))
        return n