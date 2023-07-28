class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        sums = [0] * (n + 1)
        for i in range(n):
            sums[i+1] = sums[i] + nums[i]
        ans = 0
        q = collections.deque()
        for i in range(n+1):
            while q and sums[i] <= sums[q[-1]]:
                q.pop()
            while q and sums[i] - sums[q[0]] >= k:
                q.popleft()
            ans += len(q)
            q.append(i)
        return ans