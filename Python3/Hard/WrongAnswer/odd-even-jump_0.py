class Solution:
    def oddEvenJumps(self, arr: List[int]) -> int:
        
        n = len(arr)
        odd = [0] * n
        even = [0] * n
        odd[n-1] = even[n-1] = 1
        res = 1
        stack = [n-1]
        for i in range(n-2, -1, -1):
            while stack and arr[stack[-1]] < arr[i]:
                odd[stack.pop()] = i
            while stack and arr[stack[-1]] > arr[i]:
                even[stack.pop()] = i
            stack.append(i)
        for i in range(n-2, -1, -1):
            odd[i] = even[odd[i]]
            even[i] = odd[even[i]]
            res += odd[i] == i
        return res