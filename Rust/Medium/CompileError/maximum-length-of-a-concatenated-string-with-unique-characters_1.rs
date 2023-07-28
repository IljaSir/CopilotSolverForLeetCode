impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut dp = vec![0];
        for s in arr {
            let mut mask = 0;
            for c in s.chars() {
                let bit = 1 << (c as u8 - b'a');
                if mask & bit > 0 {
                    mask = 0;
                    break;
                }
                mask |= bit;
            }
            if mask == 0 {
                continue;
            }
            for i in (0..dp.len()).rev() {
                if dp[i] & mask == 0 {
                    dp.push(dp[i] | mask);
                }
            }
        }
        dp.iter().map(|x| x.count_ones() as i32).max().unwrap()
    }
}