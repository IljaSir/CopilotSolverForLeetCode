class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        res = n + 1
        q = collections.deque()
        psum = [0] * (n + 1)
        for i in range(n):
            psum[i+1] = psum[i] + nums[i]
        for i in range(n + 1):
            while q and psum[i] <= psum[q[-1]]:
                q.pop()
            while q and psum[i] - psum[q[0]] >= k:
                res = min(res, i - q.popleft())
            q.append(i)
        return res if res <= n else -1