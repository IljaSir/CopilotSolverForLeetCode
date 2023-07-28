impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut ones = 0;
        for n in &nums {
            if *n == 1 {
                ones += 1;
            }
        }
        let mut max_ones = 0;
        let mut cur_ones = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == 1 {
                cur_ones += 1;
            }
            if i >= ones {
                if nums[i-ones] == 1 {
                    cur_ones -= 1;
                }
            }
            max_ones = max_ones.max(cur_ones);
            i += 1;
        }
        ones as i32 - max_ones
    }
}