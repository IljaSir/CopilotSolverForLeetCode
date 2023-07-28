class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        res = set()
        cur = set()
        for i in arr:
            cur = {i} | {i | j for j in cur}
            res |= cur
        return len(res)