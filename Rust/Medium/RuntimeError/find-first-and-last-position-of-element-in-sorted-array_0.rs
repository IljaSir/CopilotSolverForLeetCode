impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut result = vec![-1, -1];
        while left <= right {
            let mid = left + (right - left) / 2;
            if nums[mid] == target {
                let mut l = mid;
                let mut r = mid;
                while l > 0 {
                    if nums[l] == nums[l - 1] {
                        l -= 1;
                    } else {
                        break;
                    }
                }
                while r < nums.len() - 1 {
                    if nums[r] == nums[r + 1] {
                        r += 1;
                    } else {
                        break;
                    }
                }
                result[0] = l as i32;
                result[1] = r as i32;
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