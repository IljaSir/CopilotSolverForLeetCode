class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        
        # O(n) time complexity, O(n) space complexity
        # A pair (i, j) is called good if nums[i] == nums[j] and i < j.
        # So, we need to find the number of pairs (i, j) where i < j and nums[i] == nums[j]
        # We can do this by storing the number of occurrences of each number in a dict
        # Then, for each number, we can calculate the number of pairs where i < j and nums[i] == nums[j]
        # The number of pairs where i < j and nums[i] == nums[j] can be calculated by
        # n * (n - 1) / 2
        # where n is the number of occurrences of the number
        d = {}
        for num in nums:
            if num not in d:
                d[num] = 1
            else:
                d[num] += 1
        count = 0
        for num in d:
            n = d[num]
            count += n * (n - 1) / 2
        return count