impl Solution {
    pub fn sum(num1: i32, num2: i32) -> i32 {
        
        let mut num1 = num1;
        let mut num2 = num2;
        let mut carry = 0;
        let mut result = 0;
        for i in 0..32 {
            let bit1 = num1 & 1;
            let bit2 = num2 & 1;
            num1 >>= 1;
            num2 >>= 1;
            let sum = bit1 ^ bit2 ^ carry;
            carry = (bit1 & bit2) | (bit1 & carry) | (bit2 & carry);
            result |= sum << i;
        }
        result
    }
}