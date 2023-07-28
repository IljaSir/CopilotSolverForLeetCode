class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        d = dict()
        for i in range(len(s)-9):
            d[s[i:i+10]] = d.get(s[i:i+10], 0) + 1
        return [k for k,v in d.items() if v > 1]