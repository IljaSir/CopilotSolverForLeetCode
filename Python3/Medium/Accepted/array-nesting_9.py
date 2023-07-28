class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        
        visited = set()
        max_len = 0
        for i in range(len(nums)):
            if i in visited:
                continue
            visited.add(i)
            cur = nums[i]
            cur_len = 1
            while cur != i:
                cur_len += 1
                visited.add(cur)
                cur = nums[cur]
            max_len = max(max_len, cur_len)
        return max_len