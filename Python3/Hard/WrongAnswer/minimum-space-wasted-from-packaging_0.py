class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        
        packages.sort()
        n = len(packages)
        for b in boxes:
            b.sort()
        res = float('inf')
        for b in boxes:
            if b[-1] < packages[-1]:
                continue
            i = 0
            cur = 0
            for j in range(len(b)):
                while i < n and packages[i] <= b[j]:
                    cur += b[j] - packages[i]
                    i += 1
            res = min(res, cur)
        return res - sum(packages) if res < float('inf') else -1