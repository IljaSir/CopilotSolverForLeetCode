class Solution:
    def sortSentence(self, s: str) -> str:
        
        if len(s) == 0:
            return ""
        words = s.split(" ")
        words.sort(key=lambda x: x[-1])
        return " ".join([word[:-1] for word in words])