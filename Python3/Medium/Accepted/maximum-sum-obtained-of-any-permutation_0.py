class Solution:
    def maxSumRangeQuery(self, nums: List[int], requests: List[List[int]]) -> int:
        
        n = len(nums)
        freq = [0] * (n+1)
        for start, end in requests:
            freq[start] += 1
            freq[end+1] -= 1
        for i in range(1, n):
            freq[i] += freq[i-1]
        freq.pop()
        nums.sort()
        freq.sort()
        ans = 0
        for i in range(n):
            ans += nums[i] * freq[i]
        return ans % (10**9 + 7)