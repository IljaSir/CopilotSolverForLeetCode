impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        

        let mut max = 0;
        let mut i = 0;
        let mut j = height.len() - 1;
        while i < j {
            let area = (j - i) as i32 * height[i].min(height[j]);
            if area > max {
                max = area;
            }
            if height[i] < height[j] {
                i += 1;
            } else {
                j -= 1;
            }
        }
        max
    }
}