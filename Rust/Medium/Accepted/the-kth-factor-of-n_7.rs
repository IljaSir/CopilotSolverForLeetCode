impl Solution {
    pub fn kth_factor(n: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut cnt = 0;
        for i in 1..=n {
            if n % i == 0 {
                cnt += 1;
                if cnt == k {
                    res = i;
                    break;
                }
            }
        }
        if cnt < k {
            -1
        } else {
            res
        }
    }
}