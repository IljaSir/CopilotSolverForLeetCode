class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        
        n = len(nums)
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)
        suffix = [0]
        for num in nums[::-1]:
            suffix.append(suffix[-1] + num)
        suffix = suffix[::-1]
        ans = []
        for i in range(n):
            ans.append((prefix[i+1] / (i+1) - suffix[i] / (n-i), i))
        ans.sort()
        return ans[0][1]