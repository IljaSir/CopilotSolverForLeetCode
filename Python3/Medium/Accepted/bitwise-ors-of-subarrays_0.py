class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        
        ans = set()
        cur = set()
        for x in arr:
            cur = {x | y for y in cur} | {x}
            ans |= cur
        return len(ans)