impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        

        let mut red = 0;
        let mut blue = nums.len() - 1;
        let mut i = 0;
        while i <= blue {
            if nums[i] == 0 {
                nums.swap(i, red);
                red += 1;
                i += 1;
            } else if nums[i] == 2 {
                nums.swap(i, blue);
                blue -= 1;
            } else {
                i += 1;
            }
        }