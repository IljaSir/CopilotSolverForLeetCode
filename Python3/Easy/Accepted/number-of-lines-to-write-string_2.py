class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        
        line = 1
        width = 0
        for c in s:
            if width + widths[ord(c) - ord('a')] > 100:
                line += 1
                width = 0
            width += widths[ord(c) - ord('a')]
        return [line, width]