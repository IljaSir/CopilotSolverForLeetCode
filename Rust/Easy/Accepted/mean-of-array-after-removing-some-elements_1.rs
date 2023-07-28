impl Solution {
    pub fn trim_mean(arr: Vec<i32>) -> f64 {
        
        let mut arr = arr;
        arr.sort();
        let n = arr.len();
        let mut sum = 0;
        for i in 0..n {
            if i >= n / 20 && i < n - n / 20 {
                sum += arr[i];
            }
        }
        sum as f64 / (n - n / 10) as f64
    }
}