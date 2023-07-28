impl Solution {
    pub fn num_times_all_blue(flips: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut ans = 0;
        for (i, &flip) in flips.iter().enumerate() {
            max = max.max(flip);
            if max == (i + 1) as i32 {
                ans += 1;
            }
        }
        ans
    }
}