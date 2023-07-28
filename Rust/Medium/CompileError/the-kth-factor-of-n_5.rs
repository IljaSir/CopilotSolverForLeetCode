impl Solution {
    pub fn kth_factor(n: i32, k: i32) -> i32 {
        
        let mut res = -1;
        for i in 1..=n {
            if n % i == 0 {
                if k == 1 {
                    res = i;
                    break;
                } else {
                    res = i;
                    k -= 1;
                }
            }
        }
        res
    }
}