class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        m = {}
        for row in wall:
            pos = 0
            for i in range(len(row)-1):
                pos += row[i]
                m[pos] = m.get(pos, 0) + 1
        return len(wall) - max(m.values() + [0])