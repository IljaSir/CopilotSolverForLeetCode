class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        cnt = 1
        max_cnt = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                cnt += 1
            else:
                max_cnt = max(max_cnt, cnt)
                cnt = 1
        return max(max_cnt, cnt)