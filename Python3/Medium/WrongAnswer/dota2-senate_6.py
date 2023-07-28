class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        r = 0
        d = 0
        while True:
            for i in range(len(senate)):
                if senate[i] == 'R':
                    if d > 0:
                        senate = senate[:i] + 'r' + senate[i+1:]
                        d -= 1
                    else:
                        r += 1
                elif senate[i] == 'D':
                    if r > 0:
                        senate = senate[:i] + 'd' + senate[i+1:]
                        r -= 1
                    else:
                        d += 1
            if r == 0 or d == 0:
                return 'Radiant' if r > d else 'Dire'