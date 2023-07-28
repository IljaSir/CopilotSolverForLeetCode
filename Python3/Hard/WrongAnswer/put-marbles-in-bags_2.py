class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        def check(x):
            cnt = 1
            s = 0
            for w in weights:
                if s + w > x:
                    cnt += 1
                    s = w
                else:
                    s += w
            return cnt <= k
        l, r = max(weights), sum(weights)
        while l < r:
            m = (l + r) // 2
            if check(m):
                r = m
            else:
                l = m + 1
        return r