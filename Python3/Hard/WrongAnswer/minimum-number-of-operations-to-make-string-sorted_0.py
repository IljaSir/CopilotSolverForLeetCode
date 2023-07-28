class Solution:
    def makeStringSorted(self, s: str) -> int:
        
        n = len(s)
        MOD = 10 ** 9 + 7
        fac = [1]
        for i in range(1, n + 1):
            fac.append(fac[-1] * i % MOD)
        ans = 0
        for i in range(n):
            cnt = [0] * 26
            for j in range(i + 1, n):
                cnt[ord(s[j]) - ord('a')] += 1
            for j in range(26):
                if cnt[j] == 0:
                    continue
                ans += fac[n - i - 1] * cnt[j] % MOD
                ans %= MOD
            for j in range(i + 1, n):
                if s[j] < s[i]:
                    cnt[ord(s[j]) - ord('a')] -= 1
        return ans