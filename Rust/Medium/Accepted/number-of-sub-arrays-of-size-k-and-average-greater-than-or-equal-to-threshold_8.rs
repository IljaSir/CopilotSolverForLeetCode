impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let k = k as usize;
        let threshold = threshold as i32;
        let mut sum = 0;
        for i in 0..k {
            sum += arr[i];
        }
        let mut num = 0;
        if sum / k as i32 >= threshold {
            num += 1;
        }
        for i in k..arr.len() {
            sum = sum - arr[i - k] + arr[i];
            if sum / k as i32 >= threshold {
                num += 1;
            }
        }
        num
    }
}