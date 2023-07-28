class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        if len(arr) == 1:
            return 1
        if len(arr) == 2:
            if arr[0] != arr[1]:
                return 2
            else:
                return 1
        if len(arr) == 3:
            if arr[0] == arr[1] or arr[1] == arr[2]:
                return 1
            else:
                return 2
        if arr[0] == arr[1]:
            return self.maxTurbulenceSize(arr[1:])
        if arr[1] == arr[2]:
            return self.maxTurbulenceSize(arr[1:])
        if arr[0] > arr[1]:
            if arr[1] > arr[2]:
                return 1 + self.maxTurbulenceSize(arr[1:])
            else:
                return 1 + self.maxTurbulenceSize(arr[2:])
        else:
            if arr[1] > arr[2]:
                return 1 + self.maxTurbulenceSize(arr[2:])
            else:
                return 1 + self.maxTurbulenceSize(arr[1:])