class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        lookup = {}
        for i in range(len(nums)):
            if nums[i] == key:
                if i < len(nums) - 1:
                    if nums[i + 1] in lookup:
                        lookup[nums[i + 1]] += 1
                    else:
                        lookup[nums[i + 1]] = 1
        return max(lookup, key=lookup.get)