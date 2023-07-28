impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        

        let mut p0 = 0;
        let mut p2 = nums.len() - 1;
        let mut i = 0;
        while i <= p2 {
            if nums[i] == 0 {
                nums.swap(i, p0);
                p0 += 1;
                i += 1;
            } else if nums[i] == 2 {
                nums.swap(i, p2);
                p2 -= 1;
            } else {
                i += 1;
            }
        }