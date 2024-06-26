class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        
        n = len(nums)
        ans = 0
        for i in range(30):
            c = 0
            for val in nums:
                c += (val >> i) & 1
            ans += c * (n - c)
        return ans