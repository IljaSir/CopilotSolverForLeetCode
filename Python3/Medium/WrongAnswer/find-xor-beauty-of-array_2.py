class Solution:
    def xorBeauty(self, nums: List[int]) -> int:
        
        res = 0
        for i in range(30):
            cnt = 0
            for num in nums:
                if (num >> i) & 1:
                    cnt += 1
            res += (1 << i) * cnt * (len(nums) - cnt)
        return res