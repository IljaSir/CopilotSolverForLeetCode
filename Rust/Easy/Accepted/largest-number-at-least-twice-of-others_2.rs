impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut max_index = -1;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
                max_index = i as i32;
            }
        }
        for i in 0..nums.len() {
            if i as i32 != max_index && max < 2 * nums[i] {
                return -1;
            }
        }
        max_index
    }
}