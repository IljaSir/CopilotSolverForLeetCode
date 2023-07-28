class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        R = D = 0
        ban = [0] * len(senate)
        while True:
            for i, s in enumerate(senate):
                if ban[i] == 0:
                    if s == 'R':
                        if D > 0:
                            D -= 1
                            ban[i] = 1
                        else:
                            R += 1
                    else:
                        if R > 0:
                            R -= 1
                            ban[i] = 1
                        else:
                            D += 1
            if sum(ban) == len(senate):
                return 'Radiant' if R > 0 else 'Dire'