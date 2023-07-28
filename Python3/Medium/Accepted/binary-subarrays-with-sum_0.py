class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        count = collections.defaultdict(int)
        count[0] = 1
        ans = s = 0
        for x in nums:
            s += x
            ans += count[s - goal]
            count[s] += 1
        return ans