class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res = [[]]
        for n in nums:
            new_res = []
            for perm in res:
                for i in range(len(perm)+1):
                    new_res.append(perm[:i]+[n]+perm[i:])
                    if i<len(perm) and perm[i]==n:
                        break
            res = new_res
        return res