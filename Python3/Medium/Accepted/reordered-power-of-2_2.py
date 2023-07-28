class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        import collections
        c = collections.Counter(str(n))
        for i in range(31):
            if collections.Counter(str(1<<i)) == c:
                return True
        return False