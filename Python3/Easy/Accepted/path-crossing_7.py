class Solution:
    def isPathCrossing(self, path: str) -> bool:
        
        # 1st solution: naive simulation
        # Time  complexity: O(N)
        # Space complexity: O(N)
        visited = {(0, 0)}
        x = y = 0
        for c in path:
            if c == 'N': y += 1
            if c == 'S': y -= 1
            if c == 'E': x += 1
            if c == 'W': x -= 1
            if (x, y) in visited: return True
            visited.add((x, y))
        return False