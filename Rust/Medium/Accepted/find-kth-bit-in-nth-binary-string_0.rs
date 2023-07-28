impl Solution {
    pub fn find_kth_bit(n: i32, k: i32) -> char {
        
        if n == 1 {
            return '0';
        }
        let mid = 1 << (n - 1);
        if k == mid {
            return '1';
        }
        if k < mid {
            return Self::find_kth_bit(n - 1, k);
        }
        if Self::find_kth_bit(n - 1, 2 * mid - k) == '0' {
            return '1';
        }
        '0'
    }
}