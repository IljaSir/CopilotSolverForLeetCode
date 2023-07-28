impl Solution {
    pub fn max_score(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut prefix = vec![0; nums.len()];
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            prefix[i] = sum;
        }
        let mut count = 0;
        for i in 0..nums.len() {
            if prefix[i] > 0 {
                count += 1;
            }
        }
        return count;
    }
}