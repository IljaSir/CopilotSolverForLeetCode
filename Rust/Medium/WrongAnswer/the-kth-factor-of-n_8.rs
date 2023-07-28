impl Solution {
    pub fn kth_factor(n: i32, k: i32) -> i32 {
        
        let mut k = k;
        let mut i = 1;
        while k > 0 && i * i <= n {
            if n % i == 0 {
                k -= 1;
                if k == 0 {
                    return i;
                }
            }
            i += 1;
        }
        i -= 1;
        while i > 0 {
            if n % i == 0 {
                k -= 1;
                if k == 0 {
                    return n / i;
                }
            }
            i -= 1;
        }
        -1
    }
}