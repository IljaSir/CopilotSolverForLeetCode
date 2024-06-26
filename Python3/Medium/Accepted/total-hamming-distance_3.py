class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(32):
            c = 0
            for num in nums:
                c += num >> i & 1
            ans += c * (n - c)
        return ans