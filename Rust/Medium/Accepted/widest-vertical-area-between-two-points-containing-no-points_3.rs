impl Solution {
    pub fn max_width_of_vertical_area(points: Vec<Vec<i32>>) -> i32 {
        
        let mut x = points.iter().map(|p| p[0]).collect::<Vec<_>>();
        x.sort();
        x.windows(2).map(|w| w[1]-w[0]).max().unwrap_or(0)
    }
}