class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        senate = list(senate)
        n = len(senate)
        r, d = 0, 0
        for i in range(n):
            if senate[i] == 'R':
                r += 1
            else:
                d += 1
        while r > 0 and d > 0:
            for i in range(n):
                if senate[i] == 'R':
                    if r > 0:
                        r -= 1
                    else:
                        d -= 1
                elif senate[i] == 'D':
                    if d > 0:
                        d -= 1
                    else:
                        r -= 1
        return 'Radiant' if r > 0 else 'Dire'