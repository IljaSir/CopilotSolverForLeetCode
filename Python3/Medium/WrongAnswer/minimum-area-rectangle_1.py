class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        
        # find a pair of points that have the same x and y
        # find the minimum area of the rectangle
        # 1. find the points that have the same x
        # 2. find the points that have the same y
        # 3. find the points that have the same x and y
        # 4. find the minimum area
        # 5. return the minimum area
        # 6. if there is no minimum area, return 0
        points = sorted(points)
        x_dict = collections.defaultdict(list)
        y_dict = collections.defaultdict(list)
        for x, y in points:
            x_dict[x].append(y)
            y_dict[y].append(x)
        min_area = float('inf')
        for x, y_list in x_dict.items():
            for y in y_list:
                for x2 in y_dict[y]:
                    if x2 != x:
                        y_list2 = x_dict[x2]
                        for y2 in y_list2:
                            if y2 != y:
                                min_area = min(min_area, abs(x2-x)*abs(y2-y))
        return min_area if min_area != float('inf') else 0