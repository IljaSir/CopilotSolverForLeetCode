class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        
        # Sort the list
        nums.sort()
        # Initialize the minimum difference
        min_diff = float('inf')
        # Loop through the list
        for i in range(len(nums) - k + 1):
            # Get the difference between the highest and lowest of the k scores
            min_diff = min(min_diff, nums[i + k - 1] - nums[i])
        # Return the minimum possible difference
        return min_diff