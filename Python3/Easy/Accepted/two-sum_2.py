class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # 1st solution: Brute Force
        # Time  complexity: O(n^2)
        # Space complexity: O(1)
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]

        # 2nd solution: 2-pass Hash Table
        # Time  complexity: O(n)
        # Space complexity: O(n)
        # hash_table = {}
        # for i, num in enumerate(nums):
        #     hash_table[num] = i
        # for i, num in enumerate(nums):
        #     complement = target - num
        #     if complement in hash_table and hash_table[complement] != i:
        #         return [i, hash_table[complement]]

        # 3rd solution: 1-pass Hash Table
        # Time  complexity: O(n)
        # Space complexity: O(n)
        hash_table = {}
        for i, num in enumerate(nums):
            complement = target - num
            if complement in hash_table:
                return [hash_table[complement], i]
            hash_table[num] = i