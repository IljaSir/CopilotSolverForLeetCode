class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        # O(n) time, O(n) space
        seen = set()
        repeated = set()
        for i in range(len(s)-9):
            if s[i:i+10] in seen:
                repeated.add(s[i:i+10])
            else:
                seen.add(s[i:i+10])
        return list(repeated)