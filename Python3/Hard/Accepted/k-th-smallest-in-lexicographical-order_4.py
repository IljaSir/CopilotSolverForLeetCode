class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        def getPrefixCount(prefix, n):
            curr = prefix
            next = prefix + 1
            count = 0
            while curr <= n:
                count += min(n + 1, next) - curr
                curr *= 10
                next *= 10
            return count
        prefix = 1
        k -= 1
        while k > 0:
            count = getPrefixCount(prefix, n)
            if k >= count:
                prefix += 1
                k -= count
            else:
                prefix *= 10
                k -= 1
        return prefix