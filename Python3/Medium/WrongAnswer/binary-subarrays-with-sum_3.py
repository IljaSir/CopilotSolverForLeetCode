class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        # O(n) time, O(1) space
        # 2 pointers
        # left, right = 0, 0
        # curr_sum = 0
        # res = 0
        # while right < len(nums):
        #     curr_sum += nums[right]
        #     while curr_sum > goal:
        #         curr_sum -= nums[left]
        #         left += 1
        #     if curr_sum == goal:
        #         res += 1
        #         curr_sum -= nums[left]
        #         left += 1
        #     right += 1
        # return res
        # O(n) time, O(1) space
        # 2 pointers
        left, right = 0, 0
        curr_sum = 0
        res = 0
        while right < len(nums):
            curr_sum += nums[right]
            while curr_sum > goal:
                curr_sum -= nums[left]
                left += 1
            if curr_sum == goal:
                res += 1
                curr_sum -= nums[left]
                left += 1
            right += 1
        return res