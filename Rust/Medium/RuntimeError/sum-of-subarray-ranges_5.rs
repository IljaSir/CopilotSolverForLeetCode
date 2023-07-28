impl Solution {
    pub fn sub_array_ranges(nums: Vec<i32>) -> i64 {
        
        let mut result = 0;
        let mut left = vec![0; nums.len()];
        let mut right = vec![0; nums.len()];
        for i in 0..nums.len() {
            let mut j = i - 1;
            while j >= 0 && nums[j] > nums[i] {
                j = left[j] - 1;
            }
            left[i] = j + 1;
        }
        for i in (0..nums.len()).rev() {
            let mut j = i + 1;
            while j < nums.len() && nums[j] >= nums[i] {
                j = right[j];
            }
            right[i] = j;
            result += (i - left[i] + 1) as i64 * (right[i] - i) as i64 * nums[i] as i64;
        }
        result
    }
}