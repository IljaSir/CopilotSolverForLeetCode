class Solution:
    def findMinMoves(self, machines: List[int]) -> int:
        
        s = sum(machines)
        if s % len(machines) != 0: return -1
        target = s // len(machines)
        res = 0
        cur = 0
        for m in machines:
            m -= target
            cur += m
            res = max(res, abs(cur), m)
        return res