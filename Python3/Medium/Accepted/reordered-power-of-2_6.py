class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        # if n == 1:
        #     return True
        # if n == 10:
        #     return False
        # if n == 16:
        #     return True
        # if n == 24:
        #     return False
        # if n == 46:
        #     return True
        # if n == 64:
        #     return True
        # if n == 128:
        #     return True
        # if n == 256:
        #     return True
        # if n == 512:
        #     return True
        # if n == 1024:
        #     return True
        # if n == 2048:
        #     return True
        # if n == 4096:
        #     return True
        # if n == 8192:
        #     return True
        # if n == 16384:
        #     return True
        # if n == 32768:
        #     return True
        # if n == 65536:
        #     return True
        # if n == 131072:
        #     return True
        # if n == 262144:
        #     return True
        # if n == 524288:
        #     return True
        # if n == 1048576:
        #     return True
        # if n == 2097152:
        #     return True
        # if n == 4194304:
        #     return True
        # if n == 8388608:
        #     return True
        # if n == 16777216:
        #     return True
        # if n == 33554432:
        #     return True
        # if n == 67108864:
        #     return True
        # if n == 134217728:
        #     return True
        # if n == 268435456:
        #     return True
        # if n == 536870912:
        #     return True
        # return False
        return sorted(str(n)) in [sorted(str(1<<i)) for i in range(31)]