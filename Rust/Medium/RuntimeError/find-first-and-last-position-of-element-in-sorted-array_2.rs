impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut result = vec![-1, -1];
        let mut left = 0;
        let mut right = nums.len() - 1;
        while left <= right {
            let mid = (left + right) / 2;
            if nums[mid] == target {
                result[0] = mid as i32;
                result[1] = mid as i32;
                let mut left = mid - 1;
                let mut right = mid + 1;
                while left >= 0 {
                    if nums[left] == target {
                        result[0] = left as i32;
                    } else {
                        break;
                    }
                    left -= 1;
                }
                while right < nums.len() {
                    if nums[right] == target {
                        result[1] = right as i32;
                    } else {
                        break;
                    }
                    right += 1;
                }
                break;
            } else if nums[mid] < target {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result
    }
}