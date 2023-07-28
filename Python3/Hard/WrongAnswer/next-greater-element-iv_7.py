class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        
        return [sorted([nums[j] for j in range(i+1, len(nums)) if nums[j] > nums[i]])[1] if len(sorted([nums[j] for j in range(i+1, len(nums)) if nums[j] > nums[i]])) > 1 else -1 for i in range(len(nums))]