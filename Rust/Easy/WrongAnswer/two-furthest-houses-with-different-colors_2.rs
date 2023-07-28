impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = colors.len() - 1;
        let mut max_distance = 0;
        while left < right {
            if colors[left] == colors[right] {
                if colors[left] == colors[left + 1] {
                    left += 1;
                } else {
                    right -= 1;
                }
            } else {
                max_distance = std::cmp::max(max_distance, (right - left) as i32);
                if colors[left] == colors[left + 1] {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        max_distance
    }
}