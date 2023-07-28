impl Solution {
    pub fn sort_colors(nums: &mut Vec<i32>) {
        

        let mut zero = 0;
        let mut one = 0;
        let mut two = 0;
        for i in nums.iter() {
            match i {
                0 => zero += 1,
                1 => one += 1,
                2 => two += 1,
                _ => {}
            }
        }
        let mut i = 0;
        while i < nums.len() {
            if zero > 0 {
                nums[i] = 0;
                zero -= 1;
                i += 1;
            } else if one > 0 {
                nums[i] = 1;
                one -= 1;
                i += 1;
            } else if two > 0 {
                nums[i] = 2;
                two -= 1;
                i += 1;
            } else {
                break;
            }
        }