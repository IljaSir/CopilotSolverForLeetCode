impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        
        let mut max = 0;
        let mut min = 0;
        for n in nums {
            max = std::cmp::max(max + n, min);
            min = max - n;
        }
        max as i64
    }
}