class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        
        if len(arr) % 2 != 0:
            return False
        if len(arr) == 2:
            return arr[0] * 2 == arr[1] or arr[1] * 2 == arr[0]
        # count = 0
        # for i in range(len(arr)):
        #     for j in range(i + 1, len(arr)):
        #         if arr[i] * 2 == arr[j] or arr[j] * 2 == arr[i]:
        #             count += 1
        #             break
        # return count == len(arr) / 2
        arr.sort()
        for i in range(len(arr)):
            if arr[i] == 0:
                continue
            for j in range(i + 1, len(arr)):
                if arr[j] == 0:
                    continue
                if arr[i] * 2 == arr[j] or arr[j] * 2 == arr[i]:
                    arr[j] = 0
                    break
        return arr.count(0) == len(arr)