class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def findRound(first, second):
            if first > second:
                first, second = second, first
            mid = (n + 1) // 2
            if first < mid < second:
                return 1
            return 1 + findRound((first + 1) // 2, (second + 1) // 2)
        
        return [findRound(firstPlayer, secondPlayer), int(math.log2(n))]