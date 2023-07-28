class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        
        for i in range(len(nums)):
            j = i
            while True:
                j = (j + nums[j]) % len(nums)
                if j == i:
                    if nums[j] > 0:
                        if nums[j] % len(nums) == 0:
                            break
                        else:
                            return True
                    else:
                        break
                if nums[j] * nums[i] < 0:
                    break
        return False