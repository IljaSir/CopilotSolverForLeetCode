class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        
        # # 1st attempt: 100th percentile in speed
        # # O(n) time and space
        # res = ''
        # for i, c in enumerate(s):
        #     if i in spaces:
        #         res += ' '
        #     res += c
        # return res
        
        # 2nd attempt: 100th percentile in speed
        # O(n) time and space
        res = [None] * (len(s) + len(spaces))
        res[::2] = s
        res[1::2] = ' '
        return ''.join(res)