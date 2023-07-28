class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        r = d = 0
        r_ban = d_ban = 0
        for s in senate:
            if s == 'R':
                if r_ban > 0:
                    r_ban -= 1
                else:
                    d_ban += 1
                    d += 1
            else:
                if d_ban > 0:
                    d_ban -= 1
                else:
                    r_ban += 1
                    r += 1
        return 'Dire' if d > r else 'Radiant'