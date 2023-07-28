impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut i = 0;
        while i < arr.len() {
            let mut j = 0;
            while j < arr.len() - i {
                res += arr[j..j+i+1].iter().sum::<i32>();
                j += 1;
            }
            i += 2;
        }
        res
    }
}