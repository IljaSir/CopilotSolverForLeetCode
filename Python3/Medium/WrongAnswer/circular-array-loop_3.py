class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            slow = fast = i
            while nums[fast] * nums[(fast + nums[fast]) % n] > 0 and nums[fast] * nums[(fast + nums[fast] * 2) % n] > 0:
                slow = (slow + nums[slow]) % n
                fast = (fast + nums[fast] * 2) % n
                if slow == fast:
                    if slow == (slow + nums[slow]) % n:
                        break
                    return True
            slow = i
            val = nums[i]
            while nums[slow] * val > 0:
                next_ = (slow + nums[slow]) % n
                nums[slow] = 0
                slow = next_
        return False