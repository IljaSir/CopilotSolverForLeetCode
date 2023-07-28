class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        
        return ''.join([f' {s[i]}' if i in spaces else s[i] for i in range(len(s))])