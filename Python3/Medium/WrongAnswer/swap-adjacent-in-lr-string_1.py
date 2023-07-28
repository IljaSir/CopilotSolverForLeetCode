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
            if start[i] == 'L' and end[j] == 'L':
                if i < j:
                    return False
                i += 1
                j += 1
            elif start[i] == 'R' and end[j] == 'R':
                if i > j:
                    return False
                i += 1
                j += 1
            elif start[i] == 'X' and end[j] == 'X':
                i += 1
                j += 1
            else:
                i += 1
                j += 1
        return True