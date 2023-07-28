class Solution:
    def isPathCrossing(self, path: str) -> bool:
        
        # We can use a set to store all the visited locations, and check if the current location has been visited before.
        visited = set()
        visited.add((0, 0))
        x, y = 0, 0
        for d in path:
            if d == 'N':
                y += 1
            elif d == 'S':
                y -= 1
            elif d == 'E':
                x += 1
            elif d == 'W':
                x -= 1
            if (x, y) in visited:
                return True
            visited.add((x, y))
        return False