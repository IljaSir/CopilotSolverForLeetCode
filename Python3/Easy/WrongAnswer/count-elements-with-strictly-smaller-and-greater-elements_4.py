class Solution:
    def countElements(self, nums: List[int]) -> int:
        
        # sort the array
        nums.sort()
        # create a set of sorted elements
        sorted_set = set(nums)
        # count number of elements that have both a strictly smaller and a strictly greater element appear in nums
        count = 0
        for num in nums:
            if num - 1 in sorted_set and num + 1 in sorted_set:
                count += 1
        return count