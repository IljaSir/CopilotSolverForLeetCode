class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        
        if len(nums) == 1:
            return nums
        nums.sort()
        count = 1
        res = []
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                count += 1
            else:
                if count > len(nums)/3:
                    res.append(nums[i])
                count = 1
        if count > len(nums)/3:
            res.append(nums[-1])
        return res