impl Solution {
    pub fn max_score(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut prefix = vec![0; nums.len()];
        prefix[0] = nums[0];
        for i in 1..nums.len() {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        let mut count = 0;
        for i in 0..nums.len() {
            if prefix[i] > 0 {
                count += 1;
            }
        }
        count
    }
}