class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        radiant = [i for i, s in enumerate(senate) if s == 'R']
        dire = [i for i, s in enumerate(senate) if s == 'D']
        while len(radiant) > 0 and len(dire) > 0:
            if radiant[0] < dire[0]:
                radiant.append(radiant[0] + len(senate))
                radiant.pop(0)
                dire.pop(0)
            else:
                dire.append(dire[0] + len(senate))
                dire.pop(0)
                radiant.pop(0)
        return "Radiant" if len(radiant) > 0 else "Dire"