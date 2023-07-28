impl Solution {
    pub fn max_sum_range_query(nums: Vec<i32>, requests: Vec<Vec<i32>>) -> i32 {
        
        let mut counts = vec![0; nums.len()];
        let mut total = 0;
        for r in requests {
            counts[r[0] as usize] += 1;
            if r[1] as usize + 1 < nums.len() {
                counts[r[1] as usize + 1] -= 1;
            }
        }
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += counts[i];
            counts[i] = sum;
        }
        counts.sort();
        let mut nums = nums;
        nums.sort();
        let mut total = 0;
        for i in 0..nums.len() {
            total += counts[i] * nums[i];
        }
        (total % (1e9 as i32 + 7)) as i32
    }
}