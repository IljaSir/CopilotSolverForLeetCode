class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        for i, n in enumerate(nums):
            if n == 0:
                continue
            slow, fast = i, self.next(i, nums)
            while nums[fast] * nums[i] > 0 and nums[self.next(fast, nums)] * nums[i] > 0:
                if slow == fast:
                    if slow == self.next(slow, nums):
                        break
                    return True
                slow = self.next(slow, nums)
                fast = self.next(self.next(fast, nums), nums)
            slow = i
            while nums[slow] * nums[i] > 0:
                nums[slow] = 0
                slow = self.next(slow, nums)
        return False