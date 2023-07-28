class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        
        packages.sort()
        for box in boxes:
            box.sort()
        mod = 10**9 + 7
        def check(box):
            j = 0
            wasted = 0
            for i in range(len(packages)):
                while j < len(box) and box[j] < packages[i]:
                    j += 1
                if j == len(box):
                    return -1
                wasted += box[j] - packages[i]
            return wasted
        res = float('inf')
        for box in boxes:
            if box[-1] >= packages[-1]:
                res = min(res, check(box))
        return res % mod if res != float('inf') else -1