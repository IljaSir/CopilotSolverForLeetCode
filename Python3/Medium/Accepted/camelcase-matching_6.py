class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        
        def is_match(query, pattern):
            i = j = 0
            while i < len(query) and j < len(pattern):
                if query[i] == pattern[j]:
                    i += 1
                    j += 1
                elif query[i].isupper():
                    return False
                else:
                    i += 1
            if j < len(pattern):
                return False
            while i < len(query):
                if query[i].isupper():
                    return False
                i += 1
            return True
        return [is_match(query, pattern) for query in queries]