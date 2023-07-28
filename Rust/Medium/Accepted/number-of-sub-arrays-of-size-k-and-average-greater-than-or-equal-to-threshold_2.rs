impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let k = k as usize;
        let threshold = threshold as usize;
        let mut sum = 0;
        let mut count = 0;
        for i in 0..k {
            sum += arr[i] as usize;
        }
        if sum / k >= threshold {
            count += 1;
        }
        for i in k..arr.len() {
            sum = sum - arr[i - k] as usize + arr[i] as usize;
            if sum / k >= threshold {
                count += 1;
            }
        }
        count
    }
}