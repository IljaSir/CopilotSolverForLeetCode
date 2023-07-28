class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        
        def count(n, prefix):
            cur, next = prefix, prefix + 1
            cnt = 0
            while cur <= n:
                cnt += min(next, n+1) - cur
                cur *= 10
                next *= 10
            return cnt
        prefix = 1
        k -= 1
        while k > 0:
            cnt = count(n, prefix)
            if cnt <= k:
                prefix += 1
                k -= cnt
            else:
                prefix *= 10
                k -= 1
        return prefix