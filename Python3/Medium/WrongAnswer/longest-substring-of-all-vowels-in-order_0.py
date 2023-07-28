class Solution:
    def longestBeautifulSubstring(self, word: str) -> int:
        
        d={'a':1,'e':2,'i':3,'o':4,'u':5}
        # print(d['a'])
        i=0
        res=0
        while i<len(word):
            if word[i]=='a':
                j=i+1
                while j<len(word) and word[j] in d and d[word[j]]>=d[word[j-1]]:
                    j+=1
                if j<len(word) and word[j] not in d:
                    i=j
                elif j<len(word) and d[word[j]]<d[word[j-1]]:
                    i=j-1
                else:
                    res=max(res,j-i)
                    i=j
            else:
                i+=1
        return res