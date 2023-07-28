class Solution:
    def sortSentence(self, s: str) -> str:
        
        s = s.split(" ")
        l = len(s)
        for i in range(l):
            for j in range(l):
                if s[i][len(s[i])-1] < s[j][len(s[j])-1]:
                    s[i], s[j] = s[j], s[i]
        for i in range(l):
            s[i] = s[i][:-1]
        return " ".join(s)