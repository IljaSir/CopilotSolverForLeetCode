class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        
        # Solution 1
        # Runtime: 72 ms, faster than 60.45% of Python3 online submissions for Find the Duplicate Number.
        # Memory Usage: 16.8 MB, less than 15.33% of Python3 online submissions for Find the Duplicate Number.
        # nums.sort()
        # for i in range(len(nums)-1):
        #     if nums[i] == nums[i+1]:
        #         return nums[i]
        
        # Solution 2
        # Runtime: 72 ms, faster than 60.45% of Python3 online submissions for Find the Duplicate Number.
        # Memory Usage: 16.6 MB, less than 15.33% of Python3 online submissions for Find the Duplicate Number.
        # for i in range(len(nums)):
        #     if nums[abs(nums[i])] < 0:
        #         return abs(nums[i])
        #     else:
        #         nums[abs(nums[i])] = -nums[abs(nums[i])]
        
        # Solution 3
        # Runtime: 64 ms, faster than 94.39% of Python3 online submissions for Find the Duplicate Number.
        # Memory Usage: 16.6 MB, less than 15.33% of Python3 online submissions for Find the Duplicate Number.
        # slow = fast = nums[0]
        # while True:
        #     slow = nums[slow]
        #     fast = nums[nums[fast]]
        #     if slow == fast:
        #         break
        # slow = nums[0]
        # while slow != fast:
        #     slow = nums[slow]
        #     fast = nums[fast]
        # return slow
        
        # Solution 4
        # Runtime: 56 ms, faster than 99.14% of Python3 online submissions for Find the Duplicate Number.
        # Memory Usage: 16.5 MB, less than 15.33% of Python3 online submissions for Find the Duplicate Number.
        # slow = fast = nums[0]
        # while True:
        #     slow = nums[slow]
        #     fast = nums[nums[fast]]
        #     if slow == fast:
        #         break
        # slow = nums[0]
        # while slow != fast:
        #     slow = nums[slow]
        #     fast = nums