impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut start = 0;
        let mut end = nums.len() - 1;
        let mut result = vec![-1, -1];
        while start <= end {
            let mid = start + (end - start) / 2;
            if nums[mid] == target {
                if mid == 0 || nums[mid - 1] != target {
                    result[0] = mid as i32;
                    break;
                } else {
                    end = mid - 1;
                }
            } else if nums[mid] < target {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if result[0] == -1 {
            return result;
        }
        start = result[0] as usize;
        end = nums.len() - 1;
        while start <= end {
            let mid = start + (end - start) / 2;
            if nums[mid] == target {
                if mid == nums.len() - 1 || nums[mid + 1] != target {
                    result[1] = mid as i32;
                    break;
                } else {
                    start = mid + 1;
                }
            } else if nums[mid] < target {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        result
    }
}