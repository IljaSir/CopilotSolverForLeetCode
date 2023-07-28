class Solution:
    def canBeIncreasing(self, nums: List[int]) -> bool:
        
        
        pass 0:
                if nums[i] < nums[i+1]:
                    continue
                else:
                    return False
            elif i == len(nums)-1:
                if nums[i] > nums[i-1]:
                    continue
                else:
                    return False
            else:
                if nums[i] > nums[i-1] and nums[i] < nums[i+1]:
                    continue
                else:
                    return False
        return True