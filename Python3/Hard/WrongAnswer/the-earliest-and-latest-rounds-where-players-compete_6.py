class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def helper(n, first, second):
            if n == 2:
                return [1, 1]
            if first > second:
                first, second = second, first
            half = n // 2
            if first <= half < second:
                return [1, 1]
            if first > half:
                first -= half
                second -= half
            ret = helper(half, first, second)
            ret[0] += 1
            ret[1] += 1
            return ret
        return helper(n, firstPlayer, secondPlayer)