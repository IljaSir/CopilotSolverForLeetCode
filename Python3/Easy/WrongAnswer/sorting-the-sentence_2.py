class Solution:
    def sortSentence(self, s: str) -> str:
        
        return ' '.join(sorted(s.split(), key=lambda x: int(x[-1])))