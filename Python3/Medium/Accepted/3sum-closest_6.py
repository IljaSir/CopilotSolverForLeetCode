class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        
        nums.sort()
        result = sum(nums[:3])
        for i in range(len(nums)):
            j, k = i+1, len(nums)-1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if abs(s-target) < abs(result-target):
                    result = s
                if s < target:
                    j += 1
                elif s > target:
                    k -= 1
                else:
                    return s
        return result