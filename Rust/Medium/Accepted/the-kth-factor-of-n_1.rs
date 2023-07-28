impl Solution {
    pub fn kth_factor(n: i32, k: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..n+1 {
            if n % i == 0 {
                count += 1;
                if count == k {
                    return i;
                }
            }
        }
        return -1;
    }
}