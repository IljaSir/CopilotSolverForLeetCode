class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # sum[i] = sum(0, i)
        # sum[i] - sum[j] = sum(j, i)
        # sum[i] - k = sum[j]
        # so we need to find sum[j] in sum[0, i]
        # sum[j] = sum[i] - k
        # so we need to find sum[i] - k in sum[0, i]
        # so we need to find sum[i] - k in sum[0, i]
        sum_dict = {0: 1}
        sum_val = 0
        res = 0
        for num in nums:
            sum_val += num
            if sum_val - k in sum_dict:
                res += sum_dict[sum_val - k]
            if sum_val not in sum_dict:
                sum_dict[sum_val] = 1
            else:
                sum_dict[sum_val] += 1
        return res