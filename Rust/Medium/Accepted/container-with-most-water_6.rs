impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        

        let mut left = 0;
        let mut right = height.len() - 1;
        let mut max_area = 0;
        while left < right {
            let h = height[left].min(height[right]);
            let w = right - left;
            max_area = max_area.max(h * w as i32);
            if height[left] < height[right] {
                left += 1;
            } else {
                right -= 1;
            }
        }
        max_area
    }
}