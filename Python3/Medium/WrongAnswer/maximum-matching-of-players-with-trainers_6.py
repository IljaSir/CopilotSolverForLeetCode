class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        
        players.sort(reverse=True)
        trainers.sort(reverse=True)
        i = 0
        for j in range(len(trainers)):
            if i < len(players) and players[i] <= trainers[j]:
                i += 1
        return i