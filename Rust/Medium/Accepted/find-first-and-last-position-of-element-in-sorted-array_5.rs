impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        

        let mut l = 0;
        let mut r = nums.len() as i32 - 1;
        let mut ans = vec![-1, -1];
        while l <= r {
            let mid = (l + r) / 2;
            if nums[mid as usize] == target {
                ans[0] = mid;
                r = mid - 1;
            } else if nums[mid as usize] > target {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.len() as i32 - 1;
        while l <= r {
            let mid = (l + r) / 2;
            if nums[mid as usize] == target {
                ans[1] = mid;
                l = mid + 1;
            } else if nums[mid as usize] > target {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        ans
    }
}