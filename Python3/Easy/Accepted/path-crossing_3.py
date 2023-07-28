class Solution:
    def isPathCrossing(self, path: str) -> bool:
        
        x = 0
        y = 0
        history = [(0, 0)]
        for p in path:
            if p == 'N':
                y += 1
            elif p == 'S':
                y -= 1
            elif p == 'E':
                x += 1
            elif p == 'W':
                x -= 1
            if (x, y) in history:
                return True
            history.append((x, y))
        return False