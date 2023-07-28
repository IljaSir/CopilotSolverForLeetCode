impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut min = 101;
        let mut max_index = 0;
        let mut min_index = 0;
        for (i, &v) in colors.iter().enumerate() {
            if v > max {
                max = v;
                max_index = i;
            }
            if v < min {
                min = v;
                min_index = i;
            }
        }
        (max_index as i32 - min_index as i32).abs()
    }
}