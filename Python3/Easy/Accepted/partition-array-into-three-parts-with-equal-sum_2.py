class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        
        if len(arr) < 3:
            return False
        if sum(arr) % 3 != 0:
            return False
        target = sum(arr) // 3
        cur_sum, count = 0, 0
        for i in range(len(arr)):
            cur_sum += arr[i]
            if cur_sum == target:
                cur_sum = 0
                count += 1
        return count >= 3