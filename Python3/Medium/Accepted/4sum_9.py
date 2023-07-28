class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        
        if len(nums) < 4:
            return []
        nums.sort()
        res = set()
        for i in range(len(nums)-3):
            for j in range(i+1, len(nums)-2):
                l, r = j+1, len(nums)-1
                while l < r:
                    s = nums[i] + nums[j] + nums[l] + nums[r]
                    if s == target:
                        res.add((nums[i], nums[j], nums[l], nums[r]))
                        l += 1
                        r -= 1
                    elif s < target:
                        l += 1
                    else:
                        r -= 1
        return res