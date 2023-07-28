class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        dic = {}
        for row in wall:
            n = len(row)
            if n == 1:
                continue
            for i in range(n-1):
                if i == 0:
                    row[i+1] += row[i]
                else:
                    row[i+1] += row[i]
                if row[i+1] not in dic:
                    dic[row[i+1]] = 1
                else:
                    dic[row[i+1]] += 1
        if len(dic) == 0:
            return len(wall)
        return len(wall) - max(dic.values())