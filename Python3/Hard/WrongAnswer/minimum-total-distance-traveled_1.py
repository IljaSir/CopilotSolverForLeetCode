class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        
        robot.sort()
        factory.sort()
        i = 0
        j = len(factory)-1
        res = 0
        while i <= j:
            res += factory[j][0] - factory[i][0]
            j -= 1
            i += 1
        i = 0
        j = len(robot)-1
        while i <= j:
            res += robot[j] - robot[i]
            j -= 1
            i += 1
        return res