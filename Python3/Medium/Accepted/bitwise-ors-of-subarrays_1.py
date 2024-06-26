class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        res = set()
        cur = set()
        for x in arr:
            cur = {x | y for y in cur} | {x}
            res |= cur
        return len(res)