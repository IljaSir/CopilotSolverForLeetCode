class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        
        # # Solution 1 - 292 ms
        # maxNum = max(arr)
        # for i in range(k):
        #     if arr[i] == maxNum:
        #         return maxNum
        #     if arr[i] < arr[i + 1]:
        #         arr[i], arr[i + 1] = arr[i + 1], arr[i]
        # return arr[0]

        # Solution 2 - 276 ms
        maxNum = max(arr)
        for i in range(k):
            if arr[i] == maxNum:
                return maxNum
            if arr[i] < arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
        return arr[0]