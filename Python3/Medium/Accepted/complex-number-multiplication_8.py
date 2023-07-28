class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        
        def split_complex(num):
            real, imaginary = num.split('+')
            return int(real), int(imaginary[:-1])
        
        real1, imaginary1 = split_complex(num1)
        real2, imaginary2 = split_complex(num2)
        
        real = real1 * real2 - imaginary1 * imaginary2
        imaginary = real1 * imaginary2 + real2 * imaginary1
        
        return f'{real}+{imaginary}i'