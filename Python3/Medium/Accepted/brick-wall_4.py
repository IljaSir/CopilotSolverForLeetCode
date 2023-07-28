class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        
        dic = {}
        for i in range(len(wall)):
            sum = 0
            for j in range(len(wall[i])-1):
                sum += wall[i][j]
                if sum in dic:
                    dic[sum] += 1
                else:
                    dic[sum] = 1
        if len(dic) == 0:
            return len(wall)
        else:
            return len(wall) - max(dic.values())