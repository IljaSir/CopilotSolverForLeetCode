impl Solution {
    pub fn trap(height: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_index = 0;
        for i in 0..height.len() {
            if height[i] > max {
                max = height[i];
                max_index = i;
            }
        }
        let mut left_max = 0;
        let mut res = 0;
        for i in 0..max_index {
            if height[i] > left_max {
                left_max = height[i];
            } else {
                res += left_max - height[i];
            }
        }
        let mut right_max = 0;
        for i in (max_index+1..height.len()).rev() {
            if height[i] > right_max {
                right_max = height[i];
            } else {
                res += right_max - height[i];
            }
        }
        res
    }
}