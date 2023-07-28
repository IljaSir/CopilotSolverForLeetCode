class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        # # 1st solution
        # # O(n) time | O(n) space
        # n = len(nums)
        # all_nums = set(range(n+1))
        # for num in nums:
        #     all_nums.remove(num)
        # return all_nums.pop()
        # 2nd solution
        # O(n) time | O(1) space
        n = len(nums)
        expected_sum = n * (n + 1) // 2
        actual_sum = sum(nums)
        return expected_sum - actual_sum