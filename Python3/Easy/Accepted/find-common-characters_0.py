class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        
        if not words:
            return []
        res = []
        for c in words[0]:
            if all(c in w for w in words):
                res.append(c)
                words = [w.replace(c, '', 1) for w in words]
        return res