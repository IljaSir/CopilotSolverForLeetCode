impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut idx = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
                idx = i;
            }
        }
        for i in 0..nums.len() {
            if i != idx && max < 2 * nums[i] {
                return -1;
            }
        }
        idx as i32
    }
}