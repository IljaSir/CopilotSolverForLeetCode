class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        def next(i):
            return (i + nums[i]) % len(nums)
        
        for i in range(len(nums)):
            if nums[i] == 0:
                continue
            slow = fast = i
            while nums[slow] * nums[next(slow)] > 0 and nums[fast] * nums[next(fast)] > 0 and nums[fast] * nums[next(next(fast))] > 0:
                slow = next(slow)
                fast = next(next(fast))
                if slow == fast:
                    if slow == next(slow):
                        break
                    return True
            j = i
            while nums[j] * nums[next(j)] > 0:
                nums[j] = 0
                j = next(j)
        return False