class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
        ans = []
        for i in range(n):
            l = max(0, i - k)
            r = min(n, i + k + 1)
            if r - l <= 2 * k:
                ans.append(-1)
            else:
                ans.append((pre[r] - pre[l]) // (r - l))
        return ans