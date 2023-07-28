class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        
        # 1. sort banned
        # 2. use binary search to find the maximum number of integers that can be chosen
        # 3. use the number found in step 2 to find the minimum sum of the chosen integers
        # 4. if the minimum sum found in step 3 is less than or equal to maxSum, return the number found in step 2
        # 5. otherwise, return the number found in step 2 - 1
        banned.sort()
        # print(banned)
        # print(len(banned))
        # print(n)
        # print(maxSum)
        # print(n - len(banned))
        # print(maxSum - sum(banned))
        if n - len(banned) < maxSum - sum(banned):
            return n - len(banned)
        else:
            return maxSum - sum(banned)
        # return maxSum - sum(banned)
        # if maxSum - sum(banned) <= n - len(banned):
        #     return maxSum - sum(banned)
        # else:
        #     return n - len(banned)
        # if n - len(banned) < maxSum - sum(banned):
        #     return n - len(banned)
        # else:
        #     return maxSum - sum(banned)
        # return n - len(banned)
        # return maxSum - sum(banned)
        # return maxSum - sum(banned