impl Solution {
    pub fn find_kth_bit(n: i32, k: i32) -> char {
        
        let mut k = k;
        let mut n = n;
        while n > 1 {
            let half = 1 << (n - 2);
            if k == half {
                return '1';
            } else if k > half {
                k = half * 2 - k;
                n -= 1;
            } else {
                n -= 1;
            }
        }
        '0'
    }
}