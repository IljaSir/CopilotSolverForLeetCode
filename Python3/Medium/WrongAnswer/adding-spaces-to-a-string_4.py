class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        
        ans = []
        for i, c in enumerate(s):
            ans.append(c)
            if i in spaces:
                ans.append(' ')
        return ''.join(ans)