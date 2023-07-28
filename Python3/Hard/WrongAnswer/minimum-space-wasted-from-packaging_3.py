class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        
        packages.sort()
        for box in boxes:
            box.sort()
        # print(packages)
        # print(boxes)
        res = float('inf')
        for box in boxes:
            if box[-1] < packages[-1]:
                continue
            i, j = 0, 0
            cur = 0
            while i < len(box) and j < len(packages):
                if box[i] >= packages[j]:
                    cur += (box[i] - packages[j]) * (len(packages) - j)
                    j += 1
                else:
                    i += 1
            res = min(res, cur)
        return (res - sum(packages)) % (10**9 + 7) if res != float('inf') else -1