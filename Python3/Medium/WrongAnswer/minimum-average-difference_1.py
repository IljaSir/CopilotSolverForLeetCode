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
        min_avg_diff = float('inf')
        min_avg_diff_index = -1
        for i in range(n):
            avg_diff = abs(prefix[i + 1] / (i + 1) - (suffix[i] / (n - i)))
            if avg_diff < min_avg_diff:
                min_avg_diff = avg_diff
                min_avg_diff_index = i
        return min_avg_diff_index