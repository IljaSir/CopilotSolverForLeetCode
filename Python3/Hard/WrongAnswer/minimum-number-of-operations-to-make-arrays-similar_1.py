class Solution:
    def makeSimilar(self, nums: List[int], target: List[int]) -> int:
        
        diff = [0] * 2000001
        for i in range(len(nums)):
            diff[nums[i] - target[i] + 1000000] += 1
        ans = 0
        for i in range(len(diff)):
            if diff[i] % 2 == 1:
                ans += 1
        return ans // 2