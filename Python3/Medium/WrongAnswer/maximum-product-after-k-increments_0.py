class Solution:
    def maximumProduct(self, nums: List[int], k: int) -> int:
        
        nums.sort()
        n = len(nums)
        a = nums[0]
        b = nums[1]
        c = nums[-1]
        d = nums[-2]
        if a >= 0:
            return (c * d * pow(c, k - 1, 10 ** 9 + 7)) % (10 ** 9 + 7)
        if b >= 0:
            if k % 2 == 0:
                return (c * d * pow(c, k - 1, 10 ** 9 + 7)) % (10 ** 9 + 7)
            else:
                return (a * b * c * pow(c, k - 2, 10 ** 9 + 7)) % (10 ** 9 + 7)
        if c <= 0:
            return (a * b * pow(a, k - 1, 10 ** 9 + 7)) % (10 ** 9 + 7)
        if d <= 0:
            if k % 2 == 0:
                return (a * b * pow(a, k - 1, 10 ** 9 + 7)) % (10 ** 9 + 7)
            else:
                return (a * b * c * pow(c, k - 2, 10 ** 9 + 7)) % (10 ** 9 + 7)
        if k % 2 == 0:
            return (a * b * pow(a, k - 1, 10 ** 9 + 7)) % (10 ** 9 + 7)
        else:
            return (a * b * c * pow(c, k - 2, 10 ** 9 + 7)) % (10 ** 9 + 7)