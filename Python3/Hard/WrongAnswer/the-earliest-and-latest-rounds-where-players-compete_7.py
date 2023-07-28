class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        if firstPlayer > secondPlayer:
            firstPlayer, secondPlayer = secondPlayer, firstPlayer
        def getRound(n):
            return 1 if n == 2 else getRound(n // 2) + 1
        return [getRound(min(firstPlayer, n - secondPlayer + 1)), getRound(max(firstPlayer, n - secondPlayer + 1))]