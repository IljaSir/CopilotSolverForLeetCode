class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        if firstPlayer > secondPlayer:
            firstPlayer, secondPlayer = secondPlayer, firstPlayer
        def findRound(n, firstPlayer, secondPlayer):
            if n == 2:
                return 1
            mid = n // 2 + 1
            if firstPlayer < mid and secondPlayer > mid:
                return 1
            elif firstPlayer < mid and secondPlayer < mid:
                return findRound(mid - 1, firstPlayer, secondPlayer) + 1
            else:
                return findRound(mid - 1, firstPlayer - mid + 1, secondPlayer - mid + 1) + 1
        return [findRound(n, firstPlayer, secondPlayer), int(math.ceil(math.log(n, 2)))]