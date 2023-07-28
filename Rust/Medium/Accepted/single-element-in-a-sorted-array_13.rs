impl Solution {
    pub fn single_non_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut s = 0;
        let mut e = nums.len() - 1;
        while s < e {
            let m = s + (e - s) / 2;
            if m % 2 == 1 {
                if nums[m] == nums[m - 1] {
                    s = m + 1;
                } else {
                    e = m;
                }
            } else {
                if nums[m] == nums[m + 1] {
                    s = m + 2;
                } else {
                    e = m;
                }
            }
        }
        nums[s]
    }
}