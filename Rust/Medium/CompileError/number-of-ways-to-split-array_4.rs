impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut sums = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sums[i + 1] = sums[i] + nums[i];
        }_sum[j] {
                ans += 1;
            }
        }
        ans as i32
    }
}