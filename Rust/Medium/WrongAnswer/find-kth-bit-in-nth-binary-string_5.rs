impl Solution {
    pub fn find_kth_bit(n: i32, k: i32) -> char {
        
        let mut i = n;
        let mut k = k;
        let mut rev = false;
        while i > 1 {
            let l = 1 << (i - 1);
            if k == l {
                return if rev { '0' } else { '1' };
            } else if k < l {
                i -= 1;
                rev = false;
            } else {
                i -= 1;
                k = 2 * l - k;
                rev = !rev;
            }
        }
        if rev { '1' } else { '0' }
    }
}