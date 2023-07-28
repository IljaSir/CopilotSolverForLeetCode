impl Solution {
    pub fn kth_factor(n: i32, k: i32) -> i32 {
        
        let mut i = 1;
        let mut count = 0;
        while i * i <= n {
            if n % i == 0 {
                count += 1;
                if count == k {
                    return i;
                }
            }
            i += 1;
        }
        i -= 1;
        if i * i == n {
            i -= 1;
        }
        while i > 0 {
            if n % i == 0 {
                count += 1;
                if count == k {
                    return n / i;
                }
            }
            i -= 1;
        }
        -1
    }
}