class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        
        def subarrays(A, k):
            count = collections.defaultdict(int)
            res = i = 0
            for j, v in enumerate(A):
                if count[v] == 0:
                    k -= 1
                count[v] += 1
                while k < 0:
                    count[A[i]] -= 1
                    if count[A[i]] == 0:
                        k += 1
                    i += 1
                res += j - i + 1
            return res
        return subarrays(nums, k) - subarrays(nums, k - 1)