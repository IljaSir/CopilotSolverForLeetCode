class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        
        packages.sort()
        n = len(packages)
        for box in boxes:
            box.sort()
        boxes.sort(key=lambda x: x[-1])
        res = float('inf')
        for box in boxes:
            if box[-1] < packages[-1]:
                continue
            i = 0
            cur = 0
            for b in box:
                while i < n and packages[i] <= b:
                    cur += b - packages[i]
                    i += 1
            res = min(res, cur)
        return (res - sum(packages)) % (10 ** 9 + 7) if res != float('inf') else -1