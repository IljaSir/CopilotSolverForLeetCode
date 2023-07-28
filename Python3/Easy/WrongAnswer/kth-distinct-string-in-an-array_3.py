class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        seen = set()
        distinct = []
        for s in arr:
            if s not in seen:
                seen.add(s)
                distinct.append(s)
        return distinct[k - 1] if k <= len(distinct) else ""