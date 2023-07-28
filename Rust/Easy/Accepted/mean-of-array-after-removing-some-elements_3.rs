impl Solution {
    pub fn trim_mean(arr: Vec<i32>) -> f64 {
        
        let mut arr = arr;
        arr.sort();
        let len = arr.len();
        let mut sum = 0;
        for i in 0..len {
            if i >= len / 20 && i < len - len / 20 {
                sum += arr[i];
            }
        }
        sum as f64 / (len - len / 10) as f64
    }
}