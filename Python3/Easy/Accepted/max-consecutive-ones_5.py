class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        
        # print(nums)
        # count = 0
        # for i in range(len(nums)):
        #     if nums[i] == 1:
        #         count += 1
        # return count
        return max(map(len, ''.join(map(str, nums)).split('0')))