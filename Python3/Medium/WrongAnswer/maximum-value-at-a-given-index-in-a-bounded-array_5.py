class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        
        def get_sum(arr, index):
            return sum(arr[:index]) + sum(arr[index+1:])
        arr = [1 for _ in range(n)]
        while True:
            if get_sum(arr, index) + arr[index] > maxSum:
                break
            if index == 0:
                arr[index] += 1
                continue
            if index == n - 1:
                arr[index] += 1
                continue
            if arr[index - 1] < arr[index + 1]:
                arr[index - 1] += 1
                index -= 1
                continue
            if arr[index - 1] > arr[index + 1]:
                arr[index + 1] += 1
                index += 1
                continue
            arr[index - 1] += 1
            index -= 1
        return arr[index] - 1