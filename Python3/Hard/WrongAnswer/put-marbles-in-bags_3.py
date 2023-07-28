class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        def check(x):
            bags = 1
            cur = 0
            for w in weights:
                if cur + w > x:
                    bags += 1
                    cur = w
                else:
                    cur += w
            return bags <= k
        left, right = max(weights), sum(weights)
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return right - left