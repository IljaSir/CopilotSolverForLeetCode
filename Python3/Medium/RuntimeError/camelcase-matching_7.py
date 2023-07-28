class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        
        return [self.is_matched(query, pattern) for query in queries]