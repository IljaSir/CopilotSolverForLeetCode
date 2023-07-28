class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        
        n = len(nums)
        if n <= 2:
            return True
        cnt = 0
        if nums[0] > nums[1]:
            cnt += 1
            nums[0] = nums[1]
        for i in range(1, n-1):
            if nums[i] > nums[i+1]:
                cnt += 1
                if cnt > 1:
                    return False
                if nums[i-1] <= nums[i+1]:
                    nums[i] = nums[i-1]
                else:
                    nums[i+1] = nums[i]
        return True