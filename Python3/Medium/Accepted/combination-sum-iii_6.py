class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        result = []
        def dfs(nums, path, k, n):
            if k == 0 and n == 0:
                result.append(path)
                return
            for i in range(len(nums)):
                if nums[i] > n:
                    break
                dfs(nums[i+1:], path+[nums[i]], k-1, n-nums[i])
        dfs(list(range(1, 10)), [], k, n)
        return result