class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        if len(points) == 1:
            return 1
        res = 0
        for i in range(len(points)):
            x1, y1 = points[i]
            same = 0
            dic = {}
            for j in range(i+1, len(points)):
                x2, y2 = points[j]
                if x1 == x2 and y1 == y2:
                    same += 1
                elif x1 == x2:
                    dic["v"] = dic.get("v", 0) + 1
                elif y1 == y2:
                    dic["h"] = dic.get("h", 0) + 1
                else:
                    k = (y2-y1)/(x2-x1)
                    dic[k] = dic.get(k, 0) + 1
            res = max(res, same + (0 if not dic else max(dic.values())+1))
        return res