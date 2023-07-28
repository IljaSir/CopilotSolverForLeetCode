class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        firstPlayer, secondPlayer = min(firstPlayer, secondPlayer), max(firstPlayer, secondPlayer)
        def get_round(first, second):
            if first == 1 and second == n:
                return 1
            mid = (n + 1) // 2
            if first <= mid and second > mid:
                return 1
            if first <= mid:
                return 1 + get_round(first, second - mid)
            return 1 + get_round(first - mid, second - mid)
        return [get_round(firstPlayer, secondPlayer), int(log2(n))]