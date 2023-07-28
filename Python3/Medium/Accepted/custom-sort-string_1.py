class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        from collections import Counter
        count = Counter(s)
        res = ""
        for c in order:
            if c in count:
                res += c * count[c]
                del count[c]
        for c in count:
            res += c * count[c]
        return res