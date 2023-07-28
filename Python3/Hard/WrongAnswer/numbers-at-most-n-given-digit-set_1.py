class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        
        def count(k):
            if k == 0:
                return 1
            if k == 1:
                return len(digits)
            return len(digits) * count(k - 1)
        n = str(n)
        ans = 0
        for i in range(1, len(n)):
            ans += count(i)
        for i in range(len(n)):
            for d in digits:
                if d < n[i]:
                    ans += count(len(n) - i - 1)
                elif d == n[i]:
                    if i == len(n) - 1:
                        ans += 1
                else:
                    break
        return ans