class Solution:
    def waysToPartition(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        for i in range(n):
            if nums[i] == k:
                nums[i] = 0
            elif nums[i] > k:
                nums[i] = 1
            else:
                nums[i] = -1
        
        prefix = [0]
        for i in range(n):
            prefix.append(prefix[-1] + nums[i])
        
        cnt = collections.Counter(prefix)
        res = cnt[0]
        for i in range(n):
            cnt[prefix[i]] -= 1
            res = max(res, cnt[prefix[i]] + cnt[prefix[i] - 1] + 1)
        return res