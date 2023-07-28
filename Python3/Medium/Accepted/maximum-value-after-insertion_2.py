class Solution:
    def maxValue(self, n: str, x: int) -> str:
        
        # print("n: ", n)
        # print("x: ", x)
        # print("n[0]: ", n[0])
        # print("n[0] == '-': ", n[0] == '-')
        # print("int(n[0]): ", int(n[0]))
        # print("int(n[0]) < x: ", int(n[0]) < x)
        # print("int(n[0]) > x: ", int(n[0]) > x)
        # print("int(n[0]) == x: ", int(n[0]) == x)
        if n[0] == '-':
            for i in range(1, len(n)):
                if int(n[i]) > x:
                    return n[:i] + str(x) + n[i:]
            return n + str(x)
        else:
            for i in range(len(n)):
                if int(n[i]) < x:
                    return n[:i] + str(x) + n[i:]
            return n + str(x)