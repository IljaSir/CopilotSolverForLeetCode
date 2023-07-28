class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        
        # print(start, end)
        if start == end:
            return True
        if len(start) != len(end):
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
            if start[i] == 'R' and end[j] == 'R':
                if i > j:
                    return False
            if start[i] == 'X':
                i += 1
            elif end[j] == 'X':
                j += 1
            else:
                i += 1
                j += 1
        return True