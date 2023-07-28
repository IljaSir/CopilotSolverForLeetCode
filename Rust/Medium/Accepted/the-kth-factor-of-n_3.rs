impl Solution {
    pub fn kth_factor(n: i32, k: i32) -> i32 {
        
        let mut i = 1;
        let mut count = 0;
        while i <= n {
            if n % i == 0 {
                count += 1;
                if count == k {
                    return i;
                }
            }
            i += 1;
        }
        -1
    }
}