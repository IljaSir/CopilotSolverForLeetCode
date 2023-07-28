class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == 0:
                continue
            slow = i
            fast = i
            while True:
                slow = (slow + nums[slow]) % n
                fast = (fast + nums[fast]) % n
                fast = (fast + nums[fast]) % n
                if slow == fast:
                    break
            if slow == (slow + nums[slow]) % n:
                continue
            slow = i
            while slow != fast:
                slow = (slow + nums[slow]) % n
                fast = (fast + nums[fast]) % n
            if nums[slow] > 0:
                while nums[slow] > 0:
                    slow = (slow + nums[slow]) % n
                    if slow == fast:
                        return True
            else:
                while nums[slow] < 0:
                    slow = (slow + nums[slow]) % n
                    if slow == fast:
                        return True
            slow = i
            while nums[slow] != 0:
                nums[slow] = 0
                slow = (slow + nums[slow]) % n
        return False