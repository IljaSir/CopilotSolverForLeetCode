impl Solution {
    pub fn get_sum(a: i32, b: i32) -> i32 {
        

        if a == 0 { return b; }
        if b == 0 { return a; }
        let mut a = a;
        let mut b = b;
        let mut carry = 0;
        let mut sum = 0;
        let mut i = 0;
        while i < 32 {
            let a_bit = a & 1;
            let b_bit = b & 1;
            sum |= (a_bit ^ b_bit ^ carry) << i;
            carry = (a_bit & b_bit) | (a_bit & carry) | (b_bit & carry);
            a >>= 1;
            b >>= 1;
            i += 1;
        }
        sum
    }
}