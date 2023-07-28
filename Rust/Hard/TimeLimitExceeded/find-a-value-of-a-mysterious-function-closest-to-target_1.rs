impl Solution {
    pub fn closest_to_target(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut res = i32::max_value();
        let mut cur = 0;
        let mut n = arr.len();
        for i in 0..n {
            cur = arr[i];
            res = res.min((cur - target).abs());
            for j in (i + 1)..n {
                cur &= arr[j];
                res = res.min((cur - target).abs());
            }
        }
        res
    }
}