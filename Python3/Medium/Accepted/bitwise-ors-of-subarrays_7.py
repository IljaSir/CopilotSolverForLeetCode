class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        # set of all possible ORs
        res = set()
        # set of ORs of subarrays ending at current position
        cur = set()
        for a in arr:
            # add a itself
            cur = {a | b for b in cur} | {a}
            res |= cur
        return len(res)