impl Solution {
    pub fn get_sum(a: i32, b: i32) -> i32 {
        

        if a == 0 {
            return b;
        }
        if b == 0 {
            return a;
        }
        let mut a = a;
        let mut b = b;
        while b != 0 {
            let carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}