class Solution:
    def findLHS(self, nums: List[int]) -> int:
        # Time  complexity: O(n)
        # Space complexity: O(n)
        # nums.sort()
        # count = 1
        # max_count = 0
        # for i in range(1, len(nums)):
        #     if nums[i] == nums[i-1]:
        #         count += 1
        #     elif nums[i] - nums[i-1] == 1:
        #         count += 1
        #         max_count = max(max_count, count)
        #     else:
        #         count = 1
        # return max_count
        # Time  complexity: O(n)
        # Space complexity: O(n)
        count = collections.Counter(nums)
        max_count = 0
        for i in count:
            if i+1 in count:
                max_count = max(max_count, count[i]+count[i+1])
        return max_count