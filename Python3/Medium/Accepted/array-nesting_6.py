class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        visited = [False] * len(nums)
        max_len = 0
        for i in range(len(nums)):
            if not visited[i]:
                count = 0
                while not visited[i]:
                    visited[i] = True
                    i = nums[i]
                    count += 1
                max_len = max(max_len, count)
        return max_len