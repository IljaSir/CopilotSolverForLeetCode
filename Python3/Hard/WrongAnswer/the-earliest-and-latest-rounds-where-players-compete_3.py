class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def find_rounds(n, firstPlayer, secondPlayer):
            if firstPlayer > secondPlayer:
                firstPlayer, secondPlayer = secondPlayer, firstPlayer
            if firstPlayer % 2 == 1 and secondPlayer == firstPlayer + 1:
                return 1, 1
            mid = n // 2 + 1
            if firstPlayer < mid and secondPlayer > mid:
                return 1, math.ceil(math.log2(n))
            if firstPlayer < mid:
                return find_rounds(mid - 1, firstPlayer, (secondPlayer - mid) % (mid - 1) + 1)
            else:
                return find_rounds(mid - 1, firstPlayer - mid + 1, secondPlayer - mid + 1)
        return find_rounds(n, firstPlayer, secondPlayer)