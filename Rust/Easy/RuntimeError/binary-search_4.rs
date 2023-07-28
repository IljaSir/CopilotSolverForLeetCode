impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut l = 0;
        let mut r = nums.len() - 1;
        while l <= r {
            let m = (l + r) / 2;
            if nums[m] == target {
                return m as i32;
            } else if nums[m] < target {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        -1
    }
}