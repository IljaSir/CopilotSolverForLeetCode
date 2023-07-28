impl Solution {
    pub fn max_width_of_vertical_area(points: Vec<Vec<i32>>) -> i32 {
        
        let mut xs = points.iter().map(|p| p[0]).collect::<Vec<i32>>();
        xs.sort();
        let mut max = 0;
        for i in 1..xs.len() {
            max = std::cmp::max(max, xs[i] - xs[i - 1]);
        }
        max
    }
}