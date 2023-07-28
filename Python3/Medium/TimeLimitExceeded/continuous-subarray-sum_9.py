class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        
        # print(nums)
        for i in range(len(nums)):
            for j in range(i+1, len(nums)):
                # print(nums[i:j+1])
                if k == 0:
                    if sum(nums[i:j+1]) == 0:
                        return True
                else:
                    if sum(nums[i:j+1]) % k == 0:
                        return True
        return False