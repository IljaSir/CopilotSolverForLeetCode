class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        q = collections.deque()
        res = float('inf')
        sums = [0]
        for i, n in enumerate(nums):
            sums.append(sums[-1] + n)
        for i, s in enumerate(sums):
            while q and s <= sums[q[-1]]:
                q.pop()
            while q and s - sums[q[0]] >= k:
                res = min(res, i - q.popleft())
            q.append(i)
        return res if res < float('inf') else -1