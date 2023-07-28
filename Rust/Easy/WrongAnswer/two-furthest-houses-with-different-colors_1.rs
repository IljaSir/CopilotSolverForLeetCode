impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = colors.len() - 1;
        let mut max = 0;
        while left < right {
            if colors[left] == colors[right] {
                if colors[left] == colors[left + 1] {
                    left += 1;
                } else if colors[right] == colors[right - 1] {
                    right -= 1;
                } else {
                    if right - left > max {
                        max = right - left;
                    }
                    left += 1;
                    right -= 1;
                }
            } else {
                if right - left > max {
                    max = right - left;
                }
                left += 1;
                right -= 1;
            }
        }
        max as i32
    }
}