class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        
        # print(nums)
        n = len(nums)
        if n == 1:
            return [nums[0][0], nums[0][0]]
        # print(n)
        index = [0] * n
        # print(index)
        min_val = 10**5
        max_val = -10**5
        for i in range(n):
            min_val = min(min_val, nums[i][0])
            max_val = max(max_val, nums[i][0])
        # print(min_val, max_val)
        res = [min_val, max_val]
        while True:
            min_index = 0
            min_val = 10**5
            max_val = -10**5
            for i in range(n):
                if index[i] + 1 < len(nums[i]):
                    if nums[i][index[i] + 1] < min_val:
                        min_val = nums[i][index[i] + 1]
                        min_index = i
            index[min_index] += 1
            for i in range(n):
                max_val = max(max_val, nums[i][index[i]])
            if max_val - min_val < res[1] - res[0]:
                res = [min_val, max_val]
            flag = True
            for i in range(n):
                if index[i] + 1 < len(nums[i]):
                    flag = False
                    break
            if flag:
                break
        return res