impl Solution {
    pub fn number_of_cuts(n: i32) -> i32 {
        
        let n = n as f64;
        let s = (n * n - (n / 2.0).powi(2)).sqrt();
        let r = (n * n - s * s).sqrt();
        let theta = (s / r).acos();
        let res = (2.0 * std::f64::consts::PI / theta).floor();
        res as i32
    }
}