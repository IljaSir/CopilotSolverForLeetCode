class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        r, d = [], []
        for i, s in enumerate(senate):
            if s == 'R':
                r.append(i)
            else:
                d.append(i)
        while r and d:
            if r[0] < d[0]:
                r.append(r[0] + len(senate))
            else:
                d.append(d[0] + len(senate))
            r.pop(0)
            d.pop(0)
        return "Radiant" if r else "Dire"