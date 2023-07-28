class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        
        # 1. Recursion
        # Time  complexity: O(1)
        # Space complexity: O(1)
        # self.res = []
        # def helper(k, n, start, path):
        #     if k == 0 and n == 0:
        #         self.res.append(path)
        #     elif k > 0 and n > 0:
        #         for i in range(start, 10):
        #             helper(k-1, n-i, i+1, path+[i])
        # helper(k, n, 1, [])
        # return self.res
        
        # 2. Recursion
        # Time  complexity: O(1)
        # Space complexity: O(1)
        # self.res = []
        # def helper(k, n, start, path):
        #     if k == 0 and n == 0:
        #         self.res.append(path)
        #     elif k > 0 and n > 0:
        #         for i in range(start, 10):
        #             if i > n:
        #                 break
        #             helper(k-1, n-i, i+1, path+[i])
        # helper(k, n, 1, [])
        # return self.res
        
        # 3. Recursion
        # Time  complexity: O(1)
        # Space complexity: O(1)
        # self.res = []
        # def helper(k, n, start, path):
        #     if k == 0 and n == 0:
        #         self.res.append(path)
        #     elif k > 0 and n > 0:
        #         for i in range(start, min(n, 10)):
        #             helper(k-1, n-i, i+1, path+[i])
        # helper(k, n, 1, [])
        # return self.res
        
        # 4. Recursion
        # Time  complexity: O(1)
        # Space complexity: O(1)
        # self.res = []
        # def helper(k, n, start, path):
        #     if k == 0 and n == 0:
        #         self.res.append(path)
        #     elif k > 0 and n > 0:
        #         for i in range(start, min(n, 10)):