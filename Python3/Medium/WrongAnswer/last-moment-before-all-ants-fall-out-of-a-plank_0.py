class Solution:
    def getLastMoment(self, n: int, left: List[int], right: List[int]) -> int:
        
        left.sort()
        right.sort()
        if len(left) > 0 and len(right) > 0:
            return max(right[-1], n - left[0])
        elif len(left) > 0:
            return n - left[0]
        else:
            return right[-1]