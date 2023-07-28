class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        def check(x):
            cur = 0
            cnt = 0
            for w in weights:
                if cur + w > x:
                    cur = 0
                    cnt += 1
                cur += w
            return cnt + 1 <= k
        lo, hi = max(weights), sum(weights)
        while lo < hi:
            mid = (lo + hi) // 2
            if check(mid):
                hi = mid
            else:
                lo = mid + 1
        return hi