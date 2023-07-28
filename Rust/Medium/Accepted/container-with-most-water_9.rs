impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        

        let mut i = 0;
        let mut j = height.len() - 1;
        let mut max = 0;
        while i < j {
            let min = if height[i] < height[j] {
                height[i]
            } else {
                height[j]
            };
            let area = min * (j - i) as i32;
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