class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        
        ans = 0
        for i in range(32):
            c = 0
            for num in nums:
                c += (num >> i) & 1
            ans += c * (len(nums) - c)
        return ans