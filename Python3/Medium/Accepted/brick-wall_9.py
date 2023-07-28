class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        # 1. Create a dictionary
        # 2. For each row, sum the widths and add to a list
        # 3. For each sum, add to dictionary
        # 4. Find the maximum number of times a sum occurs
        # 5. Return the number of rows minus the maximum number of times a sum occurs
        d = {}
        for row in wall:
            s = 0
            for i in range(len(row)-1):
                s += row[i]
                if s in d:
                    d[s] += 1
                else:
                    d[s] = 1
        return len(wall) - max(d.values()) if d else len(wall)