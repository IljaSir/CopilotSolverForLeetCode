class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        
        packages.sort()
        for box in boxes:
            box.sort()
        ans = float('inf')
        for box in boxes:
            if box[-1] < packages[-1]:
                continue
            i = 0
            wasted = 0
            for size in box:
                while i < len(packages) and packages[i] <= size:
                    i += 1
                wasted += (i * size - sum(packages[:i]))
            ans = min(ans, wasted)
        return ans % (10 ** 9 + 7) if ans != float('inf') else -1