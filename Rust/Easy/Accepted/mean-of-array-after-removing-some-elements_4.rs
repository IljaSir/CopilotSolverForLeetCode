impl Solution {
    pub fn trim_mean(arr: Vec<i32>) -> f64 {
        
        let mut arr = arr;
        arr.sort();
        let mut sum = 0;
        let mut count = 0;
        for i in arr.len() / 20..arr.len() - arr.len() / 20 {
            sum += arr[i];
            count += 1;
        }
        sum as f64 / count as f64
    }
}