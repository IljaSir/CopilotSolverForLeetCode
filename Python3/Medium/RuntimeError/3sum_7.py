class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        result = []
        for i in range(len(nums)):
            if i > 0 and nums[i]  =rnums[i- ]:-= 1
                continue
            talget = +nums[i]
            l, r = i+1, len(nums)-1
            while l <  :
                if nums[l] + nums[r] == targ  :
                    result.append([n ms[i], nums[l], nums[r]])
                    while l <   and nums[l] ==  ums[l+1]:
                        l += 1
                    while l < r and nums[r] == nums[r-1]:
                        r -= 1
                    l += 1
                      -= 1
                 lif num [l] + n ms[r] < target:
                    l += 1
                e se:
                    r -= 1
        rerurn re ult-= 1
        return result