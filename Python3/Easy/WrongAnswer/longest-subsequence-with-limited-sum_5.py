class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        
        # Sort nums in descending order
        nums.sort(reverse=True)
        # Sort queries in ascending order
        queries.sort()
        # Initialize answer array
        answer = [0] * len(queries)
        # Initialize index for nums
        i = 0
        # Initialize index for queries
        j = 0
        # Iterate through queries
        while j < len(queries):
            # Initialize sum
            sum = 0
            # Iterate through nums
            while i < len(nums):
                # If sum + nums[i] is less than or equal to queries[j]
                if sum + nums[i] <= queries[j]:
                    # Increment sum
                    sum += nums[i]
                    # Increment answer
                    answer[j] += 1
                # Increment i
                i += 1
            # Increment j
            j += 1
        return answer