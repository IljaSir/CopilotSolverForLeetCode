class Solution:
    def isPossibleDivide(self, nums: List[int], k: int) -> bool:
        
        if len(nums) % k != 0:
            return False
        nums.sort()
        for i in range(len(nums) - k + 1):
            if nums[i] != 0:
                for j in range(i + 1, i + k):
                    if nums[j] != nums[j - 1] + 1:
                        return False
                for j in range(i, i + k):
                    nums[j] = 0
        return True