impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut res = vec![-1, -1];
        while left <= right {
            let mid = left + (right - left) / 2;
            if nums[mid] == target {
                res[0] = mid as i32;
                res[1] = mid as i32;
                let mut l = left;
                let mut r = mid;
                while l <= r {
                    let m = l + (r - l) / 2;
                    if nums[m] == target {
                        res[0] = m as i32;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                l = mid;
                r = right;
                while l <= r {
                    let m = l + (r - l) / 2;
                    if nums[m] == target {
                        res[1] = m as i32;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                break;
            } else if nums[mid] > target {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        res
    }
}