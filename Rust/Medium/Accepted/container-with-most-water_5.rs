impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        

        let mut max = 0;
        let mut l = 0;
        let mut r = height.len() - 1;
        while l < r {
            let area = (r - l) as i32 * i32::min(height[l], height[r]);
            if area > max {
                max = area;
            }
            if height[l] < height[r] {
                l += 1;
            } else {
                r -= 1;
            }
        }
        max
    }
}