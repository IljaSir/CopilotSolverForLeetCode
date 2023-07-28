class Solution:
    def countHomogenous(self, s: str) -> int:
        
        # Time  complexity: O(n)
        # Space complexity: O(1)
        MOD = 10**9 + 7
        count = 0
        ans = 0
        prev = None
        for ch in s:
            if ch != prev:
                count = 0
            count += 1
            ans += count
            ans %= MOD
            prev = ch
        return ans