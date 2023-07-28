class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        
        players.sort()
        trainers.sort()
        def binary_search(target):
            l, r = 0, len(trainers) - 1
            while l <= r:
                mid = (l + r) // 2
                if trainers[mid] >= target:
                    r = mid - 1
                else:
                    l = mid + 1
            return l
        res = 0
        for player in players:
            idx = binary_search(player)
            if idx < len(trainers):
                res += 1
                del trainers[idx]
        return res