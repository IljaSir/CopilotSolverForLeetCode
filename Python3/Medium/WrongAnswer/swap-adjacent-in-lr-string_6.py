class Solution:
    def canTransform(self, start: str, end: str) -> bool:
        
        s = list(start)
        e = list(end)
        while 'X' in s:
            s.remove('X')
        while 'X' in e:
            e.remove('X')
        if ''.join(s) != ''.join(e):
            return False
        if start.count('R') != end.count('R'):
            return False
        if start.count('L') != end.count('L'):
            return False
        i = 0
        while i < len(start):
            if start[i] == 'R' and end[i] == 'X':
                j = i + 1
                while j < len(start):
                    if start[j] == 'X' and end[j] == 'R':
                        return False
                    if start[j] == 'R' and end[j] == 'R':
                        break
                    j += 1
            if start[i] == 'L' and end[i] == 'X':
                j = i + 1
                while j < len(start):
                    if start[j] == 'X' and end[j] == 'L':
                        return False
                    if start[j] == 'L' and end[j] == 'L':
                        break
                    j += 1
            i += 1
        return True