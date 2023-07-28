class Solution:
    def reorganizeString(self, s: str) -> str:
        
        c = collections.Counter(s)
        if max(c.values()) > (len(s) + 1) // 2:
            return ""
        ans = []
        while c:
            c1 = c.most_common(2)
            if len(c1) == 1:
                ans.append(c1[0][0])
                c.pop(c1[0][0])
            else:
                ans.extend(c1[0][0] + c1[1][0])
                c[c1[0][0]] -= 1
                c[c1[1][0]] -= 1
                if c[c1[0][0]] == 0:
                    c.pop(c1[0][0])
                if c[c1[1][0]] == 0:
                    c.pop(c1[1][0])
        return ''.join(ans)