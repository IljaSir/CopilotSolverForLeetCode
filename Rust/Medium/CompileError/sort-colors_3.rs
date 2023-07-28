impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        

        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut k = 0;
        while k <= j {
            if nums[k] == 0 {
                nums.swap(i, k);
                i += 1;
                k += 1;
            } else if nums[k] == 2 {
                nums.swap(j, k);
                j -= 1;
            } else {
                k += 1;
            }
        }