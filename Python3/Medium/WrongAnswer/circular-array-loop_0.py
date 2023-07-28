class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            slow = fast = i
            while True:
                slow = (slow + nums[slow]) % n
                fast = (fast + nums[fast]) % n
                fast = (fast + nums[fast]) % n
                if nums[slow] * nums[fast] < 0 or nums[slow] * nums[(slow + nums[slow]) % n] < 0:
                    break
                if slow == fast:
                    if slow == (slow + nums[slow]) % n:
                        break
                    return True
        return False