impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        

        let len = height.len();
        let mut max = 0;
        let mut i = 0;
        let mut j = len - 1;
        while i < j {
            let h = height[i].min(height[j]);
            let w = j - i;
            max = max.max(h * w as i32);
            if height[i] < height[j] {
                i += 1;
            } else {
                j -= 1;
            }
        }
        max
    }
}