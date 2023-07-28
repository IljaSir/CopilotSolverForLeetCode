class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        
        def is_match(q, p):
            q = list(q)
            p = list(p)
            if len(q) < len(p):
                return False
            i = 0
            j = 0
            while i < len(q) and j < len(p):
                if q[i] == p[j]:
                    i += 1
                    j += 1
                elif q[i].isupper():
                    return False
                else:
                    i += 1
            if j < len(p):
                return False
            while i < len(q):
                if q[i].isupper():
                    return False
                i += 1
            return True
        return [is_match(q, pattern) for q in queries]