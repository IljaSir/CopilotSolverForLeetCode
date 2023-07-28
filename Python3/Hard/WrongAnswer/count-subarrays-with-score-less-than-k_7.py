class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        
        # 1. sort nums
        # 2. for each num, find the first num that is greater than k
        # 3. if nums[i] > k, then the number of subarrays is i
        # 4. if nums[i] < k, then the number of subarrays is i + 1
        # 5. if nums[i] == k, then the number of subarrays is i + 1
        # 6. if nums[i] == k, then the number of subarrays is i + 1
        return 0