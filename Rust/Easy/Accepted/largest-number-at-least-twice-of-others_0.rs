impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_index = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                max = nums[i];
                max_index = i;
            }
        }
        for i in 0..nums.len() {
            if i != max_index && max < 2 * nums[i] {
                return -1;
            }
        }
        return max_index as i32;
    }
}