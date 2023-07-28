class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            slow = fast = i
            direction = nums[i]
            while nums[slow] * direction > 0 and nums[fast] * direction > 0 and nums[(fast + nums[fast]) % n] * direction > 0:
                slow = (slow + nums[slow]) % n
                fast = (fast + nums[fast]) % n
                fast = (fast + nums[fast]) % n
                if slow == fast:
                    if slow == (slow + nums[slow]) % n:
                        break
                    return True
        return False