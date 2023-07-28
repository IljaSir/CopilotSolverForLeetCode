class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        
        # 1st solution
        # Time  complexity: O(n)
        # Space complexity: O(n)
        # n = len(nums)
        # odd = [0] * (n + 1)
        # even = [0] * (n + 1)
        # for i in range(n):
        #     if i % 2 == 0:
        #         even[i + 1] = even[i] + nums[i]
        #         odd[i + 1] = odd[i]
        #     else:
        #         even[i + 1] = even[i]
        #         odd[i + 1] = odd[i] + nums[i]
        # res = 0
        # for i in range(1, n + 1):
        #     if even[i - 1] + odd[n] - odd[i] == odd[i - 1] + even[n] - even[i]:
        #         res += 1
        # return res

        # 2nd solution
        # Time  complexity: O(n)
        # Space complexity: O(1)
        n = len(nums)
        odd = even = 0
        for i in range(n):
            if i % 2 == 0:
                even += nums[i]
            else:
                odd += nums[i]
        res = 0
        even_ = odd_ = 0
        for i in range(n):
            if even_ + odd - odd_ == odd_ + even - even_:
                res += 1
            if i % 2 == 0:
                even_ += nums[i]
            else:
                odd_ += nums[i]
        return res