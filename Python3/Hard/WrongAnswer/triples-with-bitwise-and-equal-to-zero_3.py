class Solution:
    def countTriplets(self, nums: List[int]) -> int:
        
        from collections import Counter
        n = len(nums)
        cnt = Counter([nums[i] & nums[j] for i in range(n) for j in range(n)])
        return sum(cnt[nums[k] & t] for k in range(n) for t in cnt)