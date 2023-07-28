class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        
        def parse(s):
            res = []
            cnt = 0
            start = 0
            for i, c in enumerate(s):
                cnt += 1 if c == "1" else -1
                if cnt == 0:
                    res.append("1" + parse(s[start + 1:i]) + "0")
                    start = i + 1
            return "".join(sorted(res, reverse=True))
        return parse(s)