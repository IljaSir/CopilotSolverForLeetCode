class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        k_closest = []
        for i in range(len(arr)):
            if len(k_closest) < k:
                k_closest.append(arr[i])
            else:
                if abs(arr[i]-x) < abs(k_closest[-1]-x):
                    k_closest.pop()
                    k_closest.append(arr[i])
                elif abs(arr[i]-x) == abs(k_closest[-1]-x):
                    if arr[i] < k_closest[-1]:
                        k_closest.pop()
                        k_closest.append(arr[i])
                else:
                    pass
        k_closest.sort()
        return k_closest