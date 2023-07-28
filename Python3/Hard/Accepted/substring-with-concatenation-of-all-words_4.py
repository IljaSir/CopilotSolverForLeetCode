class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        
        n = len(words[0])
        m = len(words)
        d = {}
        for word in words:
            d[word] = d.get(word, 0) + 1
        res = []
        for i in range(len(s) - n * m + 1):
            j = i
            dd = {}
            while j < i + n * m:
                word = s[j:j+n]
                dd[word] = dd.get(word, 0) + 1
                if word not in d or dd[word] > d[word]:
                    break
                j += n
            if j == i + n * m:
                res.append(i)
        return res