class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        
        def match(query, pattern):
            i = j = 0
            while i < len(query):
                if j < len(pattern) and query[i] == pattern[j]:
                    i += 1
                    j += 1
                elif query[i].isupper():
                    return False
                else:
                    i += 1
            return j == len(pattern)
        return [match(query, pattern) for query in queries]