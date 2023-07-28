class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        res, cur = set(), set()
        for a in arr:
            cur = {a | b for b in cur} | {a}
            res |= cur
        return len(res)