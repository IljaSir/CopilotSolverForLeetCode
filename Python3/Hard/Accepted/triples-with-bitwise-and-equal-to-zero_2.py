class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        
        cnt = collections.Counter()
        for i in range(len(nums)):
            for j in range(len(nums)):
                cnt[nums[i] & nums[j]] += 1
        ans = 0
        for k in range(len(nums)):
            for x in range(2**16):
                if x & nums[k] == 0:
                    ans += cnt[x]
        return ans