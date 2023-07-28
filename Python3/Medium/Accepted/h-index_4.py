class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        citations.sort()
        for i, c in enumerate(citations):
            if c >= len(citations) - i:
                return len(citations) - i
        return 0