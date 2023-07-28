class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        
        # Time  complexity: O(N)
        # Space complexity: O(1)
        def take(s, k):
            cnt = [0] * 3
            for i in range(len(s)):
                cnt[ord(s[i]) - ord('a')] += 1
                if i >= k:
                    cnt[ord(s[i - k]) - ord('a')] -= 1
                if i >= k - 1 and all(x >= k for x in cnt):
                    return True
            return False
        lo, hi = 0, len(s)
        while lo < hi:
            mi = lo + (hi - lo) // 2
            if take(s, mi):
                hi = mi
            else:
                lo = mi + 1
        return lo if lo < len(s) else -1