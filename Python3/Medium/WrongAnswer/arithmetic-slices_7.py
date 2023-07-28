class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        slices = []
        for i in range(0, len(nums)-2):
            if nums[i+1] - nums[i] == nums[i+2] - nums[i+1]:
                slices.append([nums[i], nums[i+1], nums[i+2]])
        if len(slices) == 0:
            return 0
        for i in range(0, len(slices)):
            j = i + 1
            while j < len(slices):
                if slices[i][-1] == slices[j][0]:
                    slices[i].append(slices[j][1])
                    slices[j][0] = slices[j][1]
                else:
                    j += 1
        return len(slices)