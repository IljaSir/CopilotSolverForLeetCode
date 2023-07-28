class Solution:
    def makeSimilar(self, nums: List[int], target: List[int]) -> int:
        
        n = len(nums)
        diff = [0] * n
        for i in range(n):
            diff[i] = nums[i] - target[i]
        diff.sort()
        ans = 0
        for i in range(n):
            if diff[i] > 0:
                ans += 1
                j = bisect.bisect_left(diff, -diff[i], i+1)
                if j < n and diff[j] == -diff[i]:
                    diff[j] = 0
        return ans