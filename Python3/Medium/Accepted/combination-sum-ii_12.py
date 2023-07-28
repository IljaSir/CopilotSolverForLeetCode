class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = []
        candidates.sort()
        def dfs(nums, target, index, path, result):
            if target < 0:
                return
            if target == 0:
                result.append(path)
                return
            for i in range(index, len(nums)):
                if i > index and nums[i] == nums[i-1]:
                    continue
                dfs(nums, target-nums[i], i+1, path+[nums[i]], result)
        dfs(candidates, target, 0, [], result)
        return result