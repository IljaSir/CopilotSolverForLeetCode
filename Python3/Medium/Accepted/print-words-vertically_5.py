class Solution:
    def printVertically(self, s: str) -> List[str]:
        
        words = s.split()
        max_len = max([len(word) for word in words])
        vertical = []
        for i in range(max_len):
            vertical.append("".join([word[i] if len(word) > i else " " for word in words]))
        return [v.rstrip() for v in vertical]