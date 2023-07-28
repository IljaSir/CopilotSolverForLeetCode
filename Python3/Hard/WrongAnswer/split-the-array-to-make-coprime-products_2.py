class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            while b:
                a, b = b, a%b
            return a
        
        n = len(nums)
        if n == 1:
            return 0
        if n == 2:
            return 1 if gcd(nums[0], nums[1]) == 1 else -1
        
        left, right = [0]*n, [0]*n
        left[0], right[-1] = nums[0], nums[-1]
        for i in range(1, n):
            left[i] = gcd(left[i-1], nums[i])
            right[n-i-1] = gcd(right[n-i], nums[n-i-1])
        
        for i in range(n-1):
            if gcd(left[i], right[i+1]) == 1:
                return i+1
        return -1