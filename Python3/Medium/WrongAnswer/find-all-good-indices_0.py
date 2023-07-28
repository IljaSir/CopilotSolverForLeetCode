class Solution:
    def goodIndices(self, nums: List[int], k: int) -> List[int]:
        
        ans = []
        for i in range(k, len(nums) - k):
            if all(nums[i - k] >= nums[i - j] for j in range(1, k + 1)) and all(nums[i + j] >= nums[i + k] for j in range(1, k + 1)):
                ans.append(i)
        return ans