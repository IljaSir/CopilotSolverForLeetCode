impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut l = 0;
        let mut r = nums.len();
        while l < r {
            let m = (l + r) / 2;
            if nums[m] < target {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if l < nums.len() && nums[l] == target {
            l as i32
        } else {
            -1
        }
    }
}