impl Solution {
    pub fn num_times_all_blue(flips: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut max = 0;
        for i in 0..flips.len() {
            max = max.max(flips[i] as usize);
            if max == i + 1 {
                res += 1;
            }
        }
        res
    }
}