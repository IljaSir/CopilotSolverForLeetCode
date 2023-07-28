class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        if len(nums) < 2:
            return -1
        if key not in nums:
            return -1
        count = {}
        for i in range(len(nums)):
            if nums[i] == key and i + 1 < len(nums):
                if nums[i+1] not in count:
                    count[nums[i+1]] = 1
                else:
                    count[nums[i+1]] += 1
        if len(count) == 0:
            return -1
        return max(count, key=count.get)