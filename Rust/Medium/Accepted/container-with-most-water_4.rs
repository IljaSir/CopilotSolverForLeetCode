impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        

        let mut max_area = 0;
        let mut l = 0;
        let mut r = height.len() - 1;
        while l < r {
            let h = height[l].min(height[r]);
            max_area = max_area.max(h * (r - l) as i32);
            if height[l] < height[r] {
                l += 1;
            } else {
                r -= 1;
            }
        }
        max_area
    }
}