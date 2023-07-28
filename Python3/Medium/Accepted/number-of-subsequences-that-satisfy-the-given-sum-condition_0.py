class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        mod = 10**9 + 7
        ans = 0
        left, right = 0, len(nums) - 1
        pow2 = [1]
        for i in range(1, len(nums) + 1):
            pow2.append(pow2[-1] * 2 % mod)
        while left <= right:
            if nums[left] + nums[right] > target:
                right -= 1
            else:
                ans = (ans + pow2[right - left]) % mod
                left += 1
        return ans