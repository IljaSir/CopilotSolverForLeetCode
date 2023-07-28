class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # prefix sum
        # O(n^2)
        # n = len(nums)
        # s = [0]
        # for i in range(n):
        #     s.append(s[-1]+nums[i])
        # ans = 0
        # for i in range(n):
        #     for j in range(i+1, n+1):
        #         if s[j]-s[i] == k:
        #             ans += 1
        # return ans

        # O(n)
        # prefix sum
        # s[i] - s[j] = k
        # s[i] = s[j] + k
        # s[j] = s[i] - k
        # s[j] in seen
        n = len(nums)
        s = 0
        ans = 0
        seen = {0:1}
        for i in range(n):
            s += nums[i]
            if s-k in seen:
                ans += seen[s-k]
            if s in seen:
                seen[s] += 1
            else:
                seen[s] = 1
        return ans