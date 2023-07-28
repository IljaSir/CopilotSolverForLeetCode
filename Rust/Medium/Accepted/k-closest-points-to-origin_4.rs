impl Solution {
    pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut points = points;
        points.sort_by(|a, b| (a[0].pow(2) + a[1].pow(2)).cmp(&(b[0].pow(2) + b[1].pow(2))));
        points[..k as usize].to_vec()
    }
}