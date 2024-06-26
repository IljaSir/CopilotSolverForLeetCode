class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        
        # 1. calculate the sum of each k subarray
        # 2. calculate the max sum of k subarray
        # 3. calculate the max sum of 2 subarray
        # 4. calculate the max sum of 3 subarray
        # 5. return the start index of 3 subarray
        n = len(nums)
        sum_k = [0] * (n-k+1)
        sum_k[0] = sum(nums[:k])
        for i in range(1, n-k+1):
            sum_k[i] = sum_k[i-1] - nums[i-1] + nums[i+k-1]
        max_sum1 = [0] * (n-k+1)
        max_sum1[0] = sum_k[0]
        for i in range(1, n-k+1):
            max_sum1[i] = max(max_sum1[i-1], sum_k[i])
        max_sum2 = [0] * (n-2*k+1)
        max_sum2[0] = max_sum1[k] + sum_k[k]
        for i in range(1, n-2*k+1):
            max_sum2[i] = max(max_sum2[i-1], max_sum1[i+k] + sum_k[i+k])
        max_sum3 = [0] * (n-3*k+1)
        max_sum3[0] = max_sum2[2*k] + sum_k[2*k]
        for i in range(1, n-3*k+1):
            max_sum3[i] = max(max_sum3[i-1], max_sum2[i+k] + sum_k[i+k])
        # print(max_sum1)
        # print(max_sum2)
        # print(max_sum3)
        start1 = max_sum1.index(max(max_sum1))
        start2 = max_sum2.index(max(max_sum2))
        start3 = max_sum3.index(max(max_sum3))
        return [start1, start2, start3]