class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        res = n + 1
        presum = [0]
        for i in range(n):
            presum.append(presum[-1] + nums[i])
        q = collections.deque()
        for i in range(n + 1):
            while q and presum[i] - presum[q[0]] >= k:
                res = min(res, i - q.popleft())
            while q and presum[i] <= presum[q[-1]]:
                q.pop()
            q.append(i)
        return res if res <= n else -1