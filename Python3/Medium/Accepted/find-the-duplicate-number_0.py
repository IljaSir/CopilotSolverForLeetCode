class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        
        slow = fast = finder = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        while True:
            slow = nums[slow]
            finder = nums[finder]
            if slow == finder:
                return slow