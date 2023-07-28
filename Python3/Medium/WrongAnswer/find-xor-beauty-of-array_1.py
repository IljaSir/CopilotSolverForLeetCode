class Solution:
    def xorBeauty(self, nums: List[int]) -> int:
        
        res = 0
        for i in range(32):
            cnt = 0
            for num in nums:
                if num & (1 << i):
                    cnt += 1
            res += ((1 << i) % 1000000007) * cnt * (len(nums) - cnt)
        return res % 1000000007