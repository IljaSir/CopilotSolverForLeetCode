class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        p = sorted(p)
        out = []
        for i in range(len(s)-len(p)+1):
            if sorted(s[i:i+len(p)]) == p:
                out.append(i)
        return out