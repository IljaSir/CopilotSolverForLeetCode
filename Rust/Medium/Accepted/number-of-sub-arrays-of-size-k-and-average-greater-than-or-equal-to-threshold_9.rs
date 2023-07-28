impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let mut sum = 0;
        let mut result = 0;
        let mut i = 0;
        for j in 0..arr.len() {
            sum += arr[j];
            if j as i32 >= k - 1 {
                if sum as i32 / k >= threshold {
                    result += 1;
                }
                sum -= arr[i];
                i += 1;
            }
        }
        result
    }
}