class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        
        a = arr.count(1)
        if a == 0:
            return [0,len(arr)-1]
        if a % 3 != 0:
            return [-1,-1]
        a = a // 3
        b = 0
        c = 0
        d = 0
        e = 0
        f = 0
        for i in range(len(arr)):
            if arr[i] == 1:
                b += 1
            if b == 1:
                c = i
                break
        for i in range(len(arr)):
            if arr[i] == 1:
                d += 1
            if d == a + 1:
                e = i
                break
        for i in range(len(arr)):
            if arr[i] == 1:
                f += 1
            if f == 2*a + 1:
                g = i
                break
        if arr[c:e] == arr[e:g] == arr[g:]:
            return [e-1,g]
        else:
            return [-1,-1]