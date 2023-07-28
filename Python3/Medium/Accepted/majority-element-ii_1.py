class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        
        n = len(nums)
        if n == 1:
            return nums
        elif n == 2:
            if nums[0] == nums[1]:
                return [nums[0]]
            else:
                return nums
        else:
            nums.sort()
            i = 0
            count = 1
            res = []
            while i < n - 1:
                if nums[i] == nums[i+1]:
                    count += 1
                    if count > n/3 and nums[i] not in res:
                        res.append(nums[i])
                else:
                    count = 1
                i += 1
            return res