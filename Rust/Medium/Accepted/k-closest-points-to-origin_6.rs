impl Solution {
    pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut points = points;
        points.sort_by(|a, b| {
            let a = a[0].pow(2) + a[1].pow(2);
            let b = b[0].pow(2) + b[1].pow(2);
            a.cmp(&b)
        });
        points.truncate(k as usize);
        points
    }
}