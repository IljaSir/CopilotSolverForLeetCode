impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..arr.len() {
            let mut j = i;
            while j < arr.len() {
                sum += arr[j..=j].iter().sum::<i32>();
                j += 2;
            }
        }
        sum
    }
}