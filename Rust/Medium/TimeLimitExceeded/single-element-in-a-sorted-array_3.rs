impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = nums.len() - 1;
        while l < r {
            let m = (l + r) / 2;
            if m % 2 == 1 {
                if nums[m] == nums[m - 1] {
                    r = m - 2;
                } else {
                    l = m;
                }
            } else {
                if nums[m] == nums[m + 1] {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
        }
        nums[l]
    }
}