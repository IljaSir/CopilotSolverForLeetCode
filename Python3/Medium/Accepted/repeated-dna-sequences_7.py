class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        seen = set()
        out = set()
        for i in range(len(s)-10+1):
            if s[i:i+10] in seen:
                out.add(s[i:i+10])
            else:
                seen.add(s[i:i+10])
        return list(out)