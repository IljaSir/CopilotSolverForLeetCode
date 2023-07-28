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
            return Solution::find_kth_bit(n - 1, k);
        }
        if Solution::find_kth_bit(n - 1, 2 * mid - k) == '0' {
            return '1';
        }
        '0'
    }
}