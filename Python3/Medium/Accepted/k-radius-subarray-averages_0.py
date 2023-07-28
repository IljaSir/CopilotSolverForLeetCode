class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        
        n = len(nums)
        prefix_sum = [0] * (n + 1)
        for i in range(1, n + 1):
            prefix_sum[i] = prefix_sum[i - 1] + nums[i - 1]
        ans = []
        for i in range(n):
            left = max(0, i - k)
            right = min(n, i + k + 1)
            if right - left < 2 * k + 1:
                ans.append(-1)
            else:
                ans.append((prefix_sum[right] - prefix_sum[left]) // (right - left))
        return ans