impl Solution {
    pub fn max_width_of_vertical_area(points: Vec<Vec<i32>>) -> i32 {
        
        let mut xs: Vec<i32> = points.iter().map(|p| p[0]).collect();
        xs.sort();
        let mut max = 0;
        for i in 1..xs.len() {
            let d = xs[i] - xs[i-1];
            if d > max {
                max = d;
            }
        }
        max
    }
}