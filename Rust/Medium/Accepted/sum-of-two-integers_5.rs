impl Solution {
    pub fn get_sum(a: i32, b: i32) -> i32 {
        

        let mut carry = 0;
        let mut a = a;
        let mut b = b;
        let mut res = 0;
        for i in 0..32 {
            let bit_a = a & 1;
            let bit_b = b & 1;
            let bit = bit_a ^ bit_b ^ carry;
            carry = (bit_a & bit_b) | (bit_a & carry) | (bit_b & carry);
            res |= bit << i;
            a >>= 1;
            b >>= 1;
        }
        res
    }
}