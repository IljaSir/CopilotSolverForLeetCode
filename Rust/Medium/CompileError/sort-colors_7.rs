impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        

        let mut red = 0;
        let mut white = 0;
        let mut blue = 0;
        for i in nums {
            match i {
                0 => red += 1,
                1 => white += 1,
                2 => blue += 1,
                _ => (),
            }
        }
        for i in 0..nums.len() {
            if i < red {
                nums[i] = 0;
            } else if i < red + white {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }