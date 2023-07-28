impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut left = 0;
        let mut right = nums.len();
        let mut result = vec![-1, -1];
        while left < right {
            let mid = left + (right - left) / 2;
            if nums[mid] < target {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if left == nums.len() || nums[left] != target {
            return result;
        }
        result[0] = left as i32;
        right = nums.len();
        while left < right {
            let mid = left + (right - left) / 2;
            if nums[mid] > target {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        result[1] = left as i32 - 1;
        result
    }
}