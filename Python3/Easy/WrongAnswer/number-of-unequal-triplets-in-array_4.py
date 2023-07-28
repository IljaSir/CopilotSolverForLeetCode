class Solution:
    def unequalTriplets(self, nums: List[int]) -> int:
        
        nums.sort()
        n = len(nums)
        res = 0
        for i in range(n):
            for j in range(i+1, n):
                k = bisect.bisect_left(nums, nums[i]+nums[j])
                if k > j and k < n:
                    res += n-k
        return res