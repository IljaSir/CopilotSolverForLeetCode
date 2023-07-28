class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            slow = i
            fast = (i + nums[i]) % n
            if nums[fast] * nums[i] < 0:
                continue
            while nums[fast] * nums[i] > 0 and nums[(fast + nums[fast]) % n] * nums[i] > 0:
                if slow == fast:
                    if slow == (slow + nums[slow]) % n:
                        break
                    return True
                slow = (slow + nums[slow]) % n
                fast = (fast + nums[fast]) % n
                fast = (fast + nums[fast]) % n
            slow = i
            val = nums[i]
            while nums[slow] * val > 0:
                tmp = slow
                slow = (slow + nums[slow]) % n
                nums[tmp] = 0
        return False