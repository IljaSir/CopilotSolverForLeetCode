class Solution:
    def findMinMoves(self, machines: List[int]) -> int:
        
        s = sum(machines)
        if s % len(machines) != 0:
            return -1
        avg = s // len(machines)
        res = 0
        cur = 0
        for machine in machines:
            cur += machine - avg
            res = max(res, abs(cur), machine - avg)
        return res