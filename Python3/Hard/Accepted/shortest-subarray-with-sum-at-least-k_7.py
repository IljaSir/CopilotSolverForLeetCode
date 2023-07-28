class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        # Solved using monotonic queue
        # https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/1411093/Python-Monotonic-Queue-Explanation
        q = collections.deque()
        res = len(nums) + 1
        psum = [0]
        for n in nums:
            psum.append(psum[-1] + n)
        for i, n in enumerate(psum):
            while q and n - psum[q[0]] >= k:
                res = min(res, i - q.popleft())
            while q and n <= psum[q[-1]]:
                q.pop()
            q.append(i)
        return res if res <= len(nums) else -1