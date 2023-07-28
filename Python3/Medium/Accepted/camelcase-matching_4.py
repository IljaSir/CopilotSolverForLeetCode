class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        
        def match(query, pattern):
            q, p = 0, 0
            while q < len(query) and p < len(pattern):
                if query[q] == pattern[p]:
                    q += 1
                    p += 1
                elif query[q].isupper():
                    return False
                else:
                    q += 1
            if p < len(pattern):
                return False
            while q < len(query):
                if query[q].isupper():
                    return False
                q += 1
            return True

        return [match(query, pattern) for query in queries]