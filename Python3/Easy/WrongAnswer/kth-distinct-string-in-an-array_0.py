class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        seen = set()
        for s in arr:
            if s not in seen:
                seen.add(s)
                k -= 1
                if k == 0:
                    return s
        return ""