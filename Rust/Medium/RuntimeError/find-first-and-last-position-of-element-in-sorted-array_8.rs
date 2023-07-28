impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut result = vec![-1, -1];
        let mut left = 0;
        let mut right = nums.len() - 1;
        while left <= right {
            let middle = (left + right) / 2;
            if nums[middle] == target {
                if result[0] == -1 || middle < result[0] as usize {
                    result[0] = middle as i32;
                }
                if result[1] == -1 || middle > result[1] as usize {
                    result[1] = middle as i32;
                }
                if middle > 0 && nums[middle - 1] == target {
                    right = middle - 1;
                } else if middle + 1 < nums.len() && nums[middle + 1] == target {
                    left = middle + 1;
                } else {
                    break;
                }
            } else if nums[middle] > target {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        result
    }
}