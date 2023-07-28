impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut r = 0;
        let mut l = 0;
        let mut max = 0;
        let mut last = 0;
        for i in 1..colors.len() {
            if colors[i] != colors[last] {
                max = std::cmp::max(max, i - last);
                last = i;
            }
        }
        max
    }
}