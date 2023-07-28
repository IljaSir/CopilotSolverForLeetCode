class Solution:
    def maxSumTwoNoOverlap(self, nums: List[int], firstLen: int, secondLen: int) -> int:
        
        # max_sum = 0
        # for i in range(len(nums) - firstLen):
        #     first_sum = sum(nums[i:i+firstLen])
        #     for j in range(i+firstLen, len(nums) - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        #     for j in range(0, i - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        # return max_sum

        # max_sum = 0
        # for i in range(len(nums) - firstLen):
        #     first_sum = sum(nums[i:i+firstLen])
        #     for j in range(i+firstLen, len(nums) - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        #     for j in range(0, i - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        # return max_sum

        # max_sum = 0
        # for i in range(len(nums) - firstLen):
        #     first_sum = sum(nums[i:i+firstLen])
        #     for j in range(i+firstLen, len(nums) - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        #     for j in range(0, i - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        # return max_sum

        # max_sum = 0
        # for i in range(len(nums) - firstLen):
        #     first_sum = sum(nums[i:i+firstLen])
        #     for j in range(i+firstLen, len(nums) - secondLen):
        #         second_sum = sum(nums[j:j+secondLen])
        #         max_sum = max(max_sum, first_sum + second_sum)
        #     for j in range(0,