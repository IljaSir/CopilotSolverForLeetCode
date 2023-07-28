impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..arr.len() {
            let mut j = 0;
            while j + i < arr.len() {
                sum += arr[i + j];
                j += 2;
            }
        }
        sum
    }
}