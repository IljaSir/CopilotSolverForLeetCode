class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        
        def is_arithmetic(a):
            if len(a) == 2:
                return True
            a = sorted(a)
            return all(a[i+1] - a[i] == a[1] - a[0] for i in range(len(a)-1))
        return [is_arithmetic(nums[l[i]:r[i]+1]) for i in range(len(l))]