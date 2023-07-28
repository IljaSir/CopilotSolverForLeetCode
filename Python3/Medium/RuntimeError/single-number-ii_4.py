class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        
        # 1. Bit manipulation
        # Time O(n), Space O(1)
        # a, b = 0, 0
        # for num in nums:
        #     b = ~a & (b ^ num)
        #     a = ~b & (a ^ num)
        # return b

        # 2. Hash table
        # Time O(n), Space O(n)
        # d = {}
        # for num in nums:
        #     d[num] = d.get(num, 0) + 1
        # for num in d:
        #     if d[num] == 1:
        #         return num

        # 3. Math
        # Time O(n), Space O(n)
        # s = set(nums)
        # return (3 * sum(s) - sum(nums)) // 2

        # 4. Sorting
        # Time O(nlogn), Space O(1)
        # nums.sort()
        # for i in range(0, len(nums) - 2, 3):
        #     if nums[i] != nums[i + 1]:
        #         return nums[i]
        # return nums[-1]

        # 5. Sorting
        # Time O(nlogn), Space O(1)
        # nums.sort()
        # return (3 * sum(set(nums)) - sum(nums)) // 2

        # 6. Sorting
        # Time O(nlogn), Space O(1)
        # nums.sort()
        # for i in range(0, len(nums) - 2, 3):
        #     if nums[i] != nums[i + 1]:
        #         return nums[i]
        # return nums[-1]

        # 7. Sorting
        # Time O(nlogn), Space O(1)
        # nums.sort()
        # return (3 * sum(set(nums)) - sum(nums)) // 2

        # 8. Sorting
        # Time O(nlogn), Space O(1)
        # nums.sort()
        # for i in range(0, len(nums) - 2, 3):
        #     if nums[i] != nums[i + 1]:
        #         return nums[i]
        # return nums[-1]

        # 9. Sorting
        # Time O(nlogn),