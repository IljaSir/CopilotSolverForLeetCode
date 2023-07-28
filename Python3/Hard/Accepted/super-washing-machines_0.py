class Solution:
    def findMinMoves(self, machines: List[int]) -> int:
        
        total = sum(machines)
        n = len(machines)
        if total % n != 0:
            return -1
        avg = total // n
        ans = 0
        s = 0
        for m in machines:
            m -= avg
            s += m
            ans = max(ans, abs(s), m)
        return ans