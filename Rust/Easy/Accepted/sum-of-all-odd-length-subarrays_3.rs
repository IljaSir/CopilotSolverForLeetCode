impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..arr.len() {
            let mut j = i;
            while j < arr.len() {
                for k in i..=j {
                    sum += arr[k];
                }
                j += 2;
            }
        }
        sum
    }
}