class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]
        ans = n + 1
        deque = collections.deque()
        for y, py in enumerate(prefix):
            while deque and py <= prefix[deque[-1]]:
                deque.pop()
            while deque and py - prefix[deque[0]] >= k:
                ans = min(ans, y - deque.popleft())
            deque.append(y)
        return ans if ans < n + 1 else -1