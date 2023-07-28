class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        
        i = j = 0
        while i < len(start) and j < len(end):
            while i < len(start) and start[i] == 'X':
                i += 1
            while j < len(end) and end[j] == 'X':
                j += 1
            if i == len(start) or j == len(end):
                break
            if start[i] != end[j]:
                return False
            if start[i] == 'L' and i < j:
                return False
            if start[i] == 'R' and i > j:
                return False
            i += 1
            j += 1
        return i == len(start) and j == len(end)