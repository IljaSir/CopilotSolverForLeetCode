class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        
        # 1st solution: brute force, O(n^2)
        # 2nd solution: sliding window, O(n)
        # 3rd solution: monotonic queue, O(n)
        # 4th solution: prefix sum, O(nlogn)
        # 5th solution: binary search, O(nlogn)
        # 6th solution: prefix sum + monotonic queue, O(n)
        # 7th solution: prefix sum + binary search, O(nlogn)
        # 8th solution: prefix sum + monotonic queue + binary search, O(nlogn)
        
        # 8th solution: prefix sum + monotonic queue + binary search, O(nlogn)
        # https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/1419763/Python-3-8-solutions-from-O(n2)-to-O(nlogn)-with-explanation
        n = len(nums)
        ps = [0] * (n + 1)
        for i in range(1, n + 1):
            ps[i] = ps[i - 1] + nums[i - 1]
        q = collections.deque()
        res = n + 1
        for i, p in enumerate(ps):
            while q and p <= ps[q[-1]]:
                q.pop()
            while q and p - ps[q[0]] >= k:
                res = min(res, i - q.popleft())
            q.append(i)
        return res if res <= n else -1