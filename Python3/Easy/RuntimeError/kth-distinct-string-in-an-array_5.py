class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        distinct = {}
        for s in arr:
            if s not in distinct:
                distinct[s] = 1
            else:
                distinct[s] += 1
        distinct = {k: v for k, v in sorted(distinct.items(), key=lambda item: item[1])}
        for i, (k, v) in enumerate(distinct.items()):
            if i == k - 1:
                return k
        return ""