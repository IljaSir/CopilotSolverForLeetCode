class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        
        # Solution 1: using Counter
        # arr = sorted(arr)
        # count = Counter(arr)
        # for key, value in count.items():
        #     if value > len(arr) * 0.25:
        #         return key
        # return None

        # Solution 2: using two pointers
        # arr = sorted(arr)
        # n = len(arr)
        # i = 0
        # j = 0
        # while j < n:
        #     if arr[j] == arr[i]:
        #         j += 1
        #     else:
        #         i = j
        #     if j - i > n * 0.25:
        #         return arr[i]
        # return None

        # Solution 3: using binary search
        n = len(arr)
        def get_count(num):
            left = 0
            right = n - 1
            while left <= right:
                mid = (left + right) // 2
                if arr[mid] == num:
                    if mid == 0 or arr[mid - 1] != num:
                        return mid
                    else:
                        right = mid - 1
                elif arr[mid] < num:
                    left = mid + 1
                else:
                    right = mid - 1
            return -1
        for num in arr:
            count = get_count(num)
            if count != -1 and count + n * 0.25 < n:
                return num
        return None