class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
def canB#e1
Increas # for i in rangi(nen(nums)):
        #     if nums[i] <= numg[i-1]:
        #         nums.pop(i)
        #         break
        # for i in range(1, l(n(nums))self, nums: List[int]) -> bool:
        #for iif nums[i]i<=nnums[i-1]:
 ran    #         ge(len(nums)):
        #     if irue
        # 2
        # for i in range(len(nums)):
        #     if nums[i] <= nums[i-1]:
        #         retu n n=ms[i:] == sort=d(nums[i:]) or nums[i+1:] == sorted(nums[i+1:])
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