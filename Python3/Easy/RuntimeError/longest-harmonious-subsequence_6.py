class Solution:
    def findLHS(self, nums: List[int]) -> int:
        # print(nums)
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            if abs(nums[0] - nums[1]) == 1:
                return 2
            else:
                return 0
        nums.sort()
        # print(nums)
        # print(nums[0], nums[1], nums[2], nums[3], nums[4], nums[5], nums[6], nums[7])
        max_len = 0
        for i in range(len(nums)-1):
            if nums[i] == nums[i+1]:
                continue
            if nums[i] + 1 == nums[i+1]:
                # print("nums[i] == nums[i+1] == ", nums[i])
                # print("i = ", i)
                # print("nums[i+1] = ", nums[i+1])
                # print("nums[i+2] = ", nums[i+2])
                # print("nums[i+3] = ", nums[i+3])
                # print("nums[i+4] = ", nums[i+4])
                # print("nums[i+5] = ", nums[i+5])
                # print("nums[i+6] = ", nums[i+6])
                # print("nums[i+7] = ", nums[i+7])
                # print("nums[i+8] = ", nums[i+8])
                # print("nums[i+9] = ", nums[i+9])
                # print("nums[i+10] = ", nums[i+10])
                # print("nums[i+11] = ", nums[i+11])
                # print("nums[i+12] = ", nums[i+12])
                # print("nums[i+13] = ", nums[i+13])
                # print("nums[i+14] = ", nums[i+14])
                # print("nums[i+15] = ", nums[i+15])
                # print("nums[i+16] = ", nums[i+16])
                # print("nums[i+17] = ", nums[i+17])
                # print("nums[i+18] = ", nums[i+18])
                # print("nums[i+19] = ", nums[i+19])
                # print("nums[i+20