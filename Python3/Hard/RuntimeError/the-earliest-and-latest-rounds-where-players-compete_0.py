class Solution:
    def earliestAndLatest(self, n: int, firstPlayer: int, secondPlayer: int) -> List[int]:
        
        def get_round(p1, p2):
            if p1 > p2:
                p1, p2 = p2, p1
            if p1 % 2 == 1 and p2 - p1 == 1:
                return 1
            mid = (p1 + p2) // 2
            return get_round(p1, mid) + 1
        first_round = get_round(firstPlayer, secondPlayer)
        return [first_round, int(math.log(n, 2)) + 1 - first_round]