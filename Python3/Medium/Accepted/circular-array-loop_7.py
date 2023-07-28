class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        
        def next_index(i):
            n = len(nums)
            return (i + nums[i]) % n
        
        for i in range(len(nums)):
            if nums[i] == 0:
                continue
            slow, fast = i, next_index(i)
            # If nums[i] * nums[next_index(i)] is negative, this means the direction of the cycle is different from the direction of i.
            # So, we should break and continue for the next i.
            while nums[i] * nums[fast] > 0 and nums[i] * nums[next_index(fast)] > 0:
                if slow == fast:
                    # Check for loop with only one element
                    if slow == next_index(slow):
                        break
                    return True
                slow = next_index(slow)
                fast = next_index(next_index(fast))
            # We need to set all elements along the way to 0.
            j = i
            while nums[j] * nums[next_index(j)] > 0:
                nums[j] = 0
                j = next_index(j)
        return False