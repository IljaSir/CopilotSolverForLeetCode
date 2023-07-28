class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        # prefix sum
        # sliding window
        # monotonic queue
        # O(n)
        n = len(nums)
        prefix = [0] * (n+1)
        for i in range(n):
            prefix[i+1] = prefix[i] + nums[i]
        # print(prefix)
        res = 0
        q = collections.deque()
        for i in range(n+1):
            while q and prefix[i] <= prefix[q[-1]]:
                q.pop()
            while q and prefix[i] - prefix[q[0]] >= k:
                q.popleft()
            res += len(q)
            q.append(i)
        return res