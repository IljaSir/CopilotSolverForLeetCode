impl Solution {
    pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut points: Vec<(i32, i32, i32)> = points.iter().map(|v| (v[0] * v[0] + v[1] * v[1], v[0], v[1])).collect();
        points.sort();
        points.iter().take(k as usize).map(|v| vec![v.1, v.2]).collect()
    }
}