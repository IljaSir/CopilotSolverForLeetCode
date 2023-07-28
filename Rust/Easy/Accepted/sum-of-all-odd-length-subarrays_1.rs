impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let n = arr.len();
        for i in 0..n {
            let left = i + 1;
            let right = n - i;
            let left_even = (left + 1) / 2;
            let left_odd = left / 2;
            let right_even = (right + 1) / 2;
            let right_odd = right / 2;
            ans += (left_even * right_even + left_odd * right_odd) as i32 * arr[i];
        }
        ans
    }
}