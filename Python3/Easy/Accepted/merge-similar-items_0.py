class Solution:
    def mergeSimilarItems(self, items1: List[List[int]], items2: List[List[int]]) -> List[List[int]]:
        
        items1 = sorted(items1, key=lambda x: x[0])
        items2 = sorted(items2, key=lambda x: x[0])
        i, j = 0, 0
        res = []
        while i < len(items1) and j < len(items2):
            if items1[i][0] == items2[j][0]:
                res.append([items1[i][0], items1[i][1] + items2[j][1]])
                i += 1
                j += 1
            elif items1[i][0] < items2[j][0]:
                res.append(items1[i])
                i += 1
            else:
                res.append(items2[j])
                j += 1
        while i < len(items1):
            res.append(items1[i])
            i += 1
        while j < len(items2):
            res.append(items2[j])
            j += 1
        return res