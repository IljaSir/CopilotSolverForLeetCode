impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut dp = vec![0];
        let mut max = 0;
        for s in arr {
            let mut mask = 0;
            let mut dup = false;
            for c in s.chars() {
                let bit = c as usize - 'a' as usize;
                if mask & (1 << bit) > 0 {
                    dup = true;
                    break;
                }
                mask |= 1 << bit;
            }
            if dup { continue; }
            let n = dp.len();
            for i in 0..n {
                if dp[i] & mask > 0 { continue; }
                let m = dp[i] | mask;
                dp.push(m);
                max = max.max(m.count_ones() as i32);
            }
        }
        max
    }
}