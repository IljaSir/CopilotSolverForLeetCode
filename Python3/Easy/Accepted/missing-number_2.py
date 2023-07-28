class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        # 1st solution: sort, linear search
        # O(nlogn), O(1)
        # nums.sort()
        # for i in range(len(nums)):
        #     if nums[i] != i:
        #         return i
        # return len(nums)

        # 2nd solution: hash table
        # O(n), O(n)
        # hash_table = {}
        # for num in nums:
        #     hash_table[num] = 1
        # for i in range(len(nums) + 1):
        #     if i not in hash_table:
        #         return i

        # 3rd solution: Gauss' formula
        # O(n), O(1)
        # expected_sum = len(nums) * (len(nums) + 1) // 2
        # actual_sum = sum(nums)
        # return expected_sum - actual_sum

        # 4th solution: bit manipulation
        # O(n), O(1)
        missing = len(nums)
        for i, num in enumerate(nums):
            missing ^= i ^ num
        return missing