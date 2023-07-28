impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        while j < arr.len() {
            sum += arr[j];
            if j - i + 1 == k as usize {
                if sum / k >= threshold {
                    count += 1;
                }
                sum -= arr[i];
                i += 1;
            }
            j += 1;
        }
        count
    }
}