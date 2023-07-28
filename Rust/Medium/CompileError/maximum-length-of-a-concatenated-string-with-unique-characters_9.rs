impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![];
        for s in &arr {
            let mut mask = 0;
            let mut dup = false;
            for c in s.chars() {
                let bit = c as usize - 'a' as usize;
                if mask & (1 << bit) != 0 {
                    dup = true;
                    break;
                }
                mask |= 1 << bit;
            }
            if dup {
                continue;
            }
            let n = dp.len();
            for i in 0..n {
                if mask & dp[i] == 0 {
                    dp.push(mask | dp[i]);
                    res = res.max(dp[i].count_ones() as i32 + mask.count_ones() as i32);
                }
            }
            dp.push(mask);
            res = res.max(mask.count_ones() as i32);
        }
        res
    }
}