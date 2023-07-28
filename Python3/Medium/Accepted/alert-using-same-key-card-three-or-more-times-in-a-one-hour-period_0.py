class Solution:
    def alertNames(self, keyName: List[str], keyTime: List[str]) -> List[str]:
        
        res = []
        d = defaultdict(list)
        for i in range(len(keyName)):
            d[keyName[i]].append(int(keyTime[i][:2]) * 60 + int(keyTime[i][3:]))
        for k, v in d.items():
            v.sort()
            for i in range(len(v) - 2):
                if v[i + 2] - v[i] <= 60:
                    res.append(k)
                    break
        return sorted(res)