class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        
        def isMatch(query):
            i = 0
            for c in query:
                if i < len(pattern) and c == pattern[i]:
                    i += 1
                elif c.isupper():
                    return False
            return i == len(pattern)
        return [isMatch(query) for query in queries]