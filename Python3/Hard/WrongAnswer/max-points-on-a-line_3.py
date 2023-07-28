class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        if len(points) < 3:
            return len(points)
        res = 0
        for i in range(len(points)):
            dic = {}
            same = 1
            for j in range(i+1, len(points)):
                if points[i] == points[j]:
                    same += 1
                else:
                    x = points[j][0] - points[i][0]
                    y = points[j][1] - points[i][1]
                    gcd = math.gcd(x, y)
                    if gcd != 0:
                        x //= gcd
                        y //= gcd
                    dic[(x, y)] = dic.get((x, y), 0) + 1
            res = max(res, same + max(dic.values()) if dic else same)
        return res