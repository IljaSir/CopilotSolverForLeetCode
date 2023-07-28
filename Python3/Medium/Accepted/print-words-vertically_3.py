class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        words = s.split(" ")
        max_len = max([len(word) for word in words])
        res = []
        for i in range(max_len):
            word = ""
            for j in range(len(words)):
                if i < len(words[j]):
                    word += words[j][i]
                else:
                    word += " "
            res.append(word.rstrip())
        return res