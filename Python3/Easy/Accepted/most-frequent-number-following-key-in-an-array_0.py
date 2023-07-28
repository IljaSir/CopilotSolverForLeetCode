class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        count = {}
        for i in range(1, len(nums)):
            if nums[i-1] == key:
                count[nums[i]] = count.get(nums[i], 0) + 1
        return max(count, key=count.get)