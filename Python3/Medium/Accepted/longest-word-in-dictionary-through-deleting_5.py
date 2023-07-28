class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        
        res = ""
        for d in dictionary:
            i = 0
            for c in s:
                if i < len(d) and c == d[i]:
                    i += 1
            if i == len(d):
                if len(d) > len(res) or (len(d) == len(res) and d < res):
                    res = d
        return res