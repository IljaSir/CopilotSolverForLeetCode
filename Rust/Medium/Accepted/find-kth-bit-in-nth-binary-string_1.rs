impl Solution {
    pub fn find_kth_bit(n: i32, k: i32) -> char {
        
        if n == 1 {
            return '0';
        }
        let mid = 2_i32.pow(n as u32 - 1);
        if k == mid {
            return '1';
        }
        if k < mid {
            return Self::find_kth_bit(n - 1, k);
        }
        let ch = Self::find_kth_bit(n - 1, 2 * mid - k);
        if ch == '1' {
            '0'
        } else {
            '1'
        }
    }
}