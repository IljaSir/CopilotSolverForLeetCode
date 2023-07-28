class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        def coprime(a, b):
            return gcd(a, b) == 1
        n = len(nums)
        # pre[i] = nums[0] * nums[1] * ... * nums[i-1]
        pre = [1] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] * nums[i]
        # suf[i] = nums[i] * nums[i+1] * ... * nums[n-1]
        suf = [1] * (n + 1)
        for i in range(n-1, -1, -1):
            suf[i] = suf[i + 1] * nums[i]
        for i in range(n-1):
            if coprime(pre[i + 1], suf[i + 1]):
                return i
        return -1