class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        
        a = collections.Counter(arr)
        b = []
        for i in a:
            if a[i] == 1:
                b.append(i)
        if k > len(b):
            return ""
        return b[k-1]