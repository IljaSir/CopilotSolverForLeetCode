class Solution:
    def reorganizeString(self, s: str) -> str:
        
        if not s:
            return ''
        if len(s) == 1:
            return s
        cnt = collections.Counter(s)
        max_cnt = max(cnt.values())
        if max_cnt > (len(s) + 1) / 2:
            return ''
        ans = [''.join(res)