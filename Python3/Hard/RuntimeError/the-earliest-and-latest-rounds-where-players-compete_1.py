class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def getRound(firstPlayer, secondPlayer):
            if firstPlayer > secondPlayer:
                firstPlayer, secondPlayer = secondPlayer, firstPlayer
            if (secondPlayer - firstPlayer) == 1:
                return 1
            mid = (firstPlayer + secondPlayer) // 2
            if firstPlayer <= mid and mid < secondPlayer:
                return 1 + getRound(firstPlayer, mid) + getRound(mid + 1, secondPlayer)
            else:
                return 1 + getRound(firstPlayer, mid)
        return [getRound(firstPlayer, secondPlayer), getRound(1, n)]