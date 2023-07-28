class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        r = d = 0
        ban = [0] * len(senate)
        for i, s in enumerate(senate):
            if s == 'R':
                r += 1
            else:
                d += 1
        while r > 0 and d > 0:
            for i, s in enumerate(senate):
                if ban[i] == 0:
                    if s == 'R':
                        d -= 1
                        ban[i] = 1
                    else:
                        r -= 1
                        ban[i] = 1
                else:
                    ban[i] = 0
        return 'Radiant' if r > 0 else 'Dire'