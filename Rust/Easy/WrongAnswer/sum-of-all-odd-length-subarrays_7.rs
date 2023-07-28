impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..arr.len() {
            let mut start = 0;
            while start + i < arr.len() {
                for j in start..start + i + 1 {
                    sum += arr[j];
                }
                start += 1;
            }
        }
        sum
    }
}