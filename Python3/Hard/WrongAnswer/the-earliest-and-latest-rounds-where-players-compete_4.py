class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def helper(n, firstPlayer, secondPlayer):
            if n == 2:
                return [1, 1]
            mid = (n + 1) // 2
            if (firstPlayer <= mid and secondPlayer > mid) or (firstPlayer > mid and secondPlayer <= mid):
                return [1, n-1]
            if firstPlayer <= mid and secondPlayer <= mid:
                res = helper(mid, firstPlayer, secondPlayer)
                return [res[0]+1, res[1]+1]
            if firstPlayer > mid and secondPlayer > mid:
                res = helper(n-mid, firstPlayer-mid, secondPlayer-mid)
                return [res[0]+1, res[1]+1]
        return helper(n, firstPlayer, secondPlayer)