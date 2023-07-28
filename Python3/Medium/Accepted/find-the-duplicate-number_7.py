class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        
        # O(n) time, O(1) space
        # Floyd's Tortoise and Hare
        slow = fast = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        slow = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow