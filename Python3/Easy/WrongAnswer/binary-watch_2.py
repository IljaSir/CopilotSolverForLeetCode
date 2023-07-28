class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        
        def get_combination(n, k):
            res = []
            def dfs(start, path):
                if k == 0:
                    res.append(path)
                    return
                for i in range(start, n-k+1):
                    dfs(i+1, path+[i])
            dfs(0, [])
            return res
        res = []
        for i in range(min(4, turnedOn+1)):
            j = turnedOn - i
            if j > 6:
                continue
            for hour in get_combination(4, i):
                for minute in get_combination(6, j):
                    h = m = 0
                    for k in hour:
                        h += 2**k
                    for k in minute:
                        m += 2**k
                    if h <= 11 and m <= 59:
                        res.append(f"{h}:{m:02}")
        return res