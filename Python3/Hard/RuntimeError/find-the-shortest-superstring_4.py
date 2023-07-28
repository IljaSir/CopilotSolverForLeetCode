class Solution:
    def shortestSuperstring(self, words: List[str]) -> str:
        
        def overlap(a, b):
            for i in range(1, len(a)):
                if a[i:] == b[:len(a)-i]:
                    return len(a)-i
            return 0
        n = len(words)
        dp = [[0]*(1<<n) for _ in range(n)]
        parent = [[0]*(1<<n) for _ in range(n)] ans[i]):]
        return0]