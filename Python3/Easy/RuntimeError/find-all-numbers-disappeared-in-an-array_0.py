class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # # Runtime: 404 ms, faster than 15.10% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # Memory Usage: 22.4 MB, less than 5.75% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # return [i for i in range(1, len(nums) + 1) if i not in nums]
        # # Runtime: 352 ms, faster than 37.61% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # Memory Usage: 22.3 MB, less than 5.75% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # return [i for i in range(1, len(nums) + 1) if nums.count(i) == 0]
        # # Runtime: 284 ms, faster than 77.75% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # Memory Usage: 22.6 MB, less than 5.75% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # return [i for i in range(1, len(nums) + 1) if i not in set(nums)]
        # # Runtime: 292 ms, faster than 69.29% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # Memory Usage: 22.4 MB, less than 5.75% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # return [i for i in range(1, len(nums) + 1) if nums.count(i) == 0]
        # # Runtime: 216 ms, faster than 99.28% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # Memory Usage: 22.2 MB, less than 5.75% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # return [i for i in range(1, len(nums) + 1) if i not in set(nums)]
        # # Runtime: 352 ms, faster than 37.61% of Python3 online submissions for Find All Numbers Disappeared in an Array.
        # # Memory Usage