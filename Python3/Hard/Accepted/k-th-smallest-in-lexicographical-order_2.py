class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        def count(n, prefix):
            cur = prefix
            next = prefix + 1
            count = 0
            while cur <= n:
                count += min(n + 1, next) - cur
                cur *= 10
                next *= 10
            return count
        prefix = 1
        k -= 1
        while k > 0:
            steps = count(n, prefix)
            if steps <= k:
                prefix += 1
                k -= steps
            else:
                prefix *= 10
                k -= 1
        return prefix