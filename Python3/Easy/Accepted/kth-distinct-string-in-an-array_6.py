class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        counts = {}
        for s in arr:
            if s in counts:
                counts[s] += 1
            else:
                counts[s] = 1
        distinct = [s for s, c in counts.items() if c == 1]
        if k > len(distinct):
            return ""
        return distinct[k-1]