class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        def count_prefix(n, prefix):
            cur, next = prefix, prefix + 1
            count = 0
            while cur <= n:
                count += min(n + 1, next) - cur
                cur *= 10
                next *= 10
            return count
        prefix = 1
        k -= 1
        while k > 0:
            count = count_prefix(n, prefix)
            if count <= k:
                prefix += 1
                k -= count
            else:
                prefix *= 10
                k -= 1
        return prefix