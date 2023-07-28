class Solution:
    def sortSentence(self, s: str) -> str:
        
        return ' '.join(sorted(s.split(), key=lambda x: x[-1])).rstrip('1234567890')