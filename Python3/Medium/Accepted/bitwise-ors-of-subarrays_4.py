class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        prev, res = set(), set()
        for x in arr:
            prev = {x | y for y in prev} | {x}
            res |= prev
        return len(res)