class Solution:
    def minOperations(self, nums: List[int], queries: List[int]) -> List[int]:
        
        # 1. sort nums
        # 2. for each query, find the median
        # 3. find the number of elements less than the median
        # 4. find the number of elements greater than the median
        # 5. sum the difference
        # 6. sort the queries
        # 7. for each query, find the closest element in nums
        # 8. find the distance
        # 9. sum the distance
        nums.sort()
        queries.sort()
        m = len(nums)
        n = len(queries)
        result = []
        for i in range(n):
            result.append(self.findDistance(nums, m, queries[i]))
        return result