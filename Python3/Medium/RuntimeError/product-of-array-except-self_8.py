class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        # 1. Brute Force
        # 2. Two Pass
        # 3. One Pass
        # 4. One Pass with constant space
        # 5. One Pass with constant space and without division
        # 6. One Pass with constant space and without division and without multiplication
        # 7. One Pass with constant space and without division and without multiplication and without division
        # 8. One Pass with constant space and without division and without multiplication and without division and without multiplication

        # 1. Brute Force
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        # N = len(nums)
        # ans = [1] * N
        # for i in range(N):
        #     for j in range(N):
        #         if i != j:
        #             ans[i] *= nums[j]
        # return ans

        # 2. Two Pass
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(nums)
        # ans = [1] * N
        # for i in range(1, N):
        #     ans[i] = ans[i-1] * nums[i-1]
        # R = 1
        # for i in reversed(range(N)):
        #     ans[i] *= R
        #     R *= nums[i]
        # return ans

        # 3. One Pass
        # Time  complexity: O(N)
        # Space complexity: O(N)
        # N = len(nums)
        # ans = [1] * N
        # for i in range(1, N):
        #     ans[i] = ans[i-1] * nums[i-1]
        # R = 1
        # for i in reversed(range(N)):
        #     ans[i] *= R
        #     R *= nums[i]
        # return ans

        # 4. One Pass with constant space
        # Time  complexity: O(N)
        # Space complexity: O(1)
        # N = len(nums)
        # ans = [1] * N
        # for i in range(1, N):
        #     ans[i] = ans[i-1] * nums[i-1]
        # R = 1
        # for i