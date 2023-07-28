class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        target_count = {}
        for i in range(len(nums)):
            if nums[i] == key:
                if i < len(nums) - 1:
                    if nums[i + 1] in target_count:
                        target_count[nums[i + 1]] += 1
                    else:
                        target_count[nums[i + 1]] = 1
        max_count = 0
        max_target = -1
        for target, count in target_count.items():
            if count > max_count:
                max_count = count
                max_target = target
        return max_target