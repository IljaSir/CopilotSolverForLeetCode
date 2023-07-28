class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        
        packages.sort()
        n = len(packages)
        for box in boxes:
            box.sort()
        max_package = packages[-1]
        res = float('inf')
        for box in boxes:
            if box[-1] < max_package:
                continue
            i = 0
            waste = 0
            for j in range(len(box)):
                while i < n and packages[i] <= box[j]:
                    waste += box[j] - packages[i]
                    i += 1
            res = min(res, waste)
        return res % (10 ** 9 + 7) if res < float('inf') else -1