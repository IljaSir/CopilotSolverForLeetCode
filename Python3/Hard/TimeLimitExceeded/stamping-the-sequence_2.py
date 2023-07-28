class Solution:
    def movesToStamp(self, stamp: str, target: str) -> List[int]:
        
        def replace(s, t):
            i = 0
            while True:
                i = s.find(t, i)
                if i == -1:
                    break
                s = s[:i] + '?' * len(t) + s[i + len(t):]
                yield i
                i += 1
        def check(s):
            return all(c == '?' for c in s)
        res = []
        while True:
            flag = False
            for i in replace(target, stamp):
                res.append(i)
                flag = True
            if not flag:
                break
        return res[::-1] if check(target) else []