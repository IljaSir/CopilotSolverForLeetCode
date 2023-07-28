class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        
        # @lee215
        res = []
        for word in words:
            for r in res:
                if sorted(word) == sorted(r):
                    break
            else:
                res.append(word)
        return res