class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        
        count = []
        for i in range(len(nums)):
            count.append(0)
            for j in range(len(nums)):
                if nums[j] < nums[i]:
                    count[i] += 1
        return count