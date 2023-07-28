impl Solution {
    pub fn trim_mean(arr: Vec<i32>) -> f64 {
        
        let mut arr = arr;
        arr.sort();
        let n = arr.len() as f64;
        let mut sum = 0;
        let mut count = 0;
        for i in (n * 0.05) as usize..(n * 0.95) as usize {
            sum += arr[i];
            count += 1;
        }
        sum as f64 / count as f64
    }
}