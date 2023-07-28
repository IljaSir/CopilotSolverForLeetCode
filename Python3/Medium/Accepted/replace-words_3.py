class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        d = set(dictionary)
        res = []
        for word in sentence.split():
            for i in range(1, len(word)):
                if word[:i] in d:
                    res.append(word[:i])
                    break
            else:
                res.append(word)
        return ' '.join(res)