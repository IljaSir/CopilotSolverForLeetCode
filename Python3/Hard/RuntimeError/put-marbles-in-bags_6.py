class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        def check(x):
            curr = 0
            for w in weights:
                if w > x:
                    return False
                if curr + w > x:
                    curr = 0
                if curr == 0:
                    k -= 1
                curr += w
            return k >= 0

        l, r = max(weights), sum(weights)
        while l < r:
            mid = (l+r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r