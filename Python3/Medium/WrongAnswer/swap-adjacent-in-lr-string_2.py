class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        
        if start.count('X') != end.count('X'):
            return False
        if start.count('L') != end.count('L'):
            return False
        if start.count('R') != end.count('R'):
            return False
        i = 0
        j = 0
        while i < len(start) and j < len(end):
            while i < len(start) and start[i] == 'X':
                i += 1
            while j < len(end) and end[j] == 'X':
                j += 1
            if i >= len(start) and j >= len(end):
                return True
            if i >= len(start) or j >= len(end):
                return False
            if start[i] == 'R' and j < i:
                return False
            if start[i] == 'L' and j > i:
                return False
            i += 1
            j += 1
        return True