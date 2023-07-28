class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if len(s) < len(p):
            return []
        if len(s) == len(p):
            return [0] if sorted(s) == sorted(p) else []
        p = sorted(p)
        ans = []
        for i in range(len(s) - len(p) + 1):
            if sorted(s[i:i+len(p)]) == p:
                ans.append(i)
        return ans