class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        # 1
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         nums.pop(i)
        #         break
        # for i in range(1, len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         return False
        # return True
        # 2
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         return nums[i:] == sorted(nums[i:]) or nums[i+1:] == sorted(nums[i+1:])
        # return True
        # 3
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         return all(nums[i-1:i] + nums[i+1:] == sorted(nums[i-1:i] + nums[i+1:]))
        # return True
        # 4
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         return all(nums[i-1:i] + nums[i+1:] == sorted(nums[i-1:i] + nums[i+1:]))
        # return True
        # 5
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         return all(nums[i-1:i] + nums[i+1:] == sorted(nums[i-1:i] + nums[i+1:]))
        # return True
        # 6
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         return all(nums[i-1:i] + nums[i+1:] == sorted(nums[i-1:i] + nums[i+1:]))
        # return True
        # 7
        for i in range(len(nums)):
            if nums[i] <= nums[i-1]:
                return all(nums[i-1:i] + nums[i+1:] == sorted(nums[i-1:i] + nums[i+1:]))
        return True