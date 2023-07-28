impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut first = -1;
        let mut last = -1;
        let mut max = 0;
        for i in 0..colors.len() {
            if first == -1 {
                first = i as i32;
            } else if colors[i] != colors[first as usize] {
                last = i as i32;
            }
            if last != -1 {
                max = std::cmp::max(max, (last - first).abs());
            }
        }
        max
    }
}