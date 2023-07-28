class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        n = len(nums)
        ans = []
        def dfs(i, cur):
            ans.append(cur)
            for j in range(i, n):
                if j > i and nums[j] == nums[j-1]:
                    continue
                dfs(j+1, cur+[nums[j]])
        dfs(0, [])
        return ans