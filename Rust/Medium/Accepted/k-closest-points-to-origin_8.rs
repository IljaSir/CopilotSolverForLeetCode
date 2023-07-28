impl Solution {
    pub fn k_closest(points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        
        let mut ret = points.clone();
        ret.sort_by(|a, b| {
            let d1 = a[0] * a[0] + a[1] * a[1];
            let d2 = b[0] * b[0] + b[1] * b[1];
            d1.cmp(&d2)
        });
        ret[..k as usize].to_vec()
    }
}