impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        
        let mut n = n;
        let mut flag = n & 1;
        n >>= 1;
        while n > 0 {
            if flag == (n & 1) {
                return false;
            }
            flag = n & 1;
            n >>= 1;
        }
        true
    }
}