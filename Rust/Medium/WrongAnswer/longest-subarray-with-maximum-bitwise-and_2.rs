impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut res = 0;
        for i in 0..nums.len() {
            max &= nums[i];
            max = max.max(nums[i]);
            res = res.max(max.count_ones() as i32);
        }
        res
    }
}