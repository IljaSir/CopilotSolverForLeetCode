class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        
        def isArithmetic(arr):
            arr.sort()
            diff = arr[1]-arr[0]
            for i in range(2, len(arr)):
                if arr[i]-arr[i-1] != diff:
                    return False
            return True
        return [isArithmetic(nums[i:j+1]) for i, j in zip(l, r)]