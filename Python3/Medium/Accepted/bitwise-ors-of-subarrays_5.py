class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        res = set()
        last = set()
        for x in arr:
            res.add(x)
            last = {x | y for y in last} | {x}
            res |= last
        return len(res)