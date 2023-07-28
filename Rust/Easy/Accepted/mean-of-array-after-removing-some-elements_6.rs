impl Solution {
    pub fn trim_mean(arr: Vec<i32>) -> f64 {
        
        let mut arr = arr;
        arr.sort();
        let n = arr.len();
        let l = (n as f64 * 0.05) as usize;
        let r = n - l;
        arr[l..r].iter().sum::<i32>() as f64 / (r - l) as f64
    }
}