impl Solution {
    pub fn max_width_of_vertical_area(points: Vec<Vec<i32>>) -> i32 {
        
        let mut x = points.iter().map(|p| p[0]).collect::<Vec<i32>>();
        x.sort();
        let mut max = 0;
        for i in 1..x.len() {
            if x[i] - x[i-1] > max {
                max = x[i] - x[i-1];
            }
        }
        max
    }
}