class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        
        # 1. sum(nums) % k == 0
        # 2. nums[i] <= sum(nums) // k
        # 3. nums[i] <= max(nums)
        # 4. nums[i] <= sum(nums) // k
        # 5. sum(nums) // k >= max(nums)
        # 6. k <= len(nums)
        # 7. k <= sum(nums) // max(nums)
        # 8. k <= sum(nums) // max(nums) <= len(nums)
        # 9. k <= sum(nums) // max(nums) <= len(nums) < sum(nums) // min(nums)
        # 10. k <= sum(nums) // max(nums) <= len(nums) < sum(nums) // min(nums) <= sum(nums) // (sum(nums) // len(nums))
        # 11. k <= sum(nums) // max(nums) <= len(nums) < sum(nums) // min(nums) <= len(nums)
        # 12. k <= sum(nums) // max(nums) <= len(nums)
        # 13. k <= sum(nums) // max(nums) <= len(nums) <= sum(nums) // min(nums)
        # 14. k <= sum(nums) // max(nums) <= len(nums) <= sum(nums) // min(nums) <= sum(nums) // (sum(nums) // len(nums))
        # 15. k <= sum(nums) // max(nums) <= len(nums) <= sum(nums) // min(nums) <= len(nums)
        # 16. k <= sum(nums) // max(nums) <= len(nums) <= sum(nums) // min(nums)
        # 17. k <= sum(nums) // max(nums) <= len(nums) <= sum(nums) // min(nums) <= sum(nums) // (sum(nums) // len(nums)) <= sum(nums) // (sum(nums) // len(nums)) + 1 <= sum(nums) // (sum(nums) // len(nums)) + 1 < sum(nums) // (sum(nums) // len(nums)) + 2
        # 18. k <= sum(nums) // max(nums) <= len(nums) <= sum(nums) // min(nums) <= sum(nums) // (sum(nums) // len(nums)) <= sum(nums) // (sum(nums) // len(nums)) + 1 <= sum(nums) // (sum(nums) //