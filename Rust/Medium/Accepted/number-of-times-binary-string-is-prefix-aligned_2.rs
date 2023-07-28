impl Solution {
    pub fn num_times_all_blue(flips: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for i in 0..flips.len() {
            max = std::cmp::max(max, flips[i] as usize);
            if max == i + 1 {
                count += 1;
            }
        }
        count
    }
}