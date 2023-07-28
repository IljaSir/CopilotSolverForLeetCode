impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        let mut left = vec![0; arr.len()];
        let mut right = vec![0; arr.len()];
        for i in 0..arr.len() {
            let mut count = 1;
            while let Some((j, _)) = stack.last() {
                if arr[*j] < arr[i] {
                    break;
                }
                let (j, c) = stack.pop().unwrap();
                count += c;
            }
            left[i] = count;
            stack.push((i, count));
        }
        stack.clear();
        for i in (0..arr.len()).rev() {
            let mut count = 1;
            while let Some((j, _)) = stack.last() {
                if arr[*j] <= arr[i] {
                    break;
                }
                let (j, c) = stack.pop().unwrap();
                count += c;
            }
            right[i] = count;
            stack.push((i, count));
        }
        let mut sum = 0;
        for i in 0..arr.len() {
            sum = (sum + left[i] * right[i] * arr[i]) % 1000000007;
        }
        sum
    }
}