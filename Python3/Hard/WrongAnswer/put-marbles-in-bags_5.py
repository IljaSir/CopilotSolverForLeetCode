class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        def check(x):
            cnt = 0
            acc = 0
            for w in weights:
                acc += w
                if acc > x:
                    cnt += 1
                    acc = w
            cnt += 1
            return cnt <= k
        
        l, r = max(weights), sum(weights)
        while l < r:
            m = (l + r) // 2
            if check(m):
                r = m
            else:
                l = m + 1
        return r - l