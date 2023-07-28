impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut left = vec![0; arr.len()];
        let mut right = vec![0; arr.len()];
        for i in 0..arr.len() {
            let mut count = 1;
            while let Some(&j) = stack.last() {
                if arr[j] <= arr[i] {
                    break;
                }
                count += left[j];
                stack.pop();
            }
            left[i] = count;
            stack.push(i);
        }
        stack.clear();
        for i in (0..arr.len()).rev() {
            let mut count = 1;
            while let Some(&j) = stack.last() {
                if arr[j] < arr[i] {
                    break;
                }
                count += right[j];
                stack.pop();
            }
            right[i] = count;
            stack.push(i);
        }
        let mut res = 0;
        for i in 0..arr.len() {
            res += arr[i] * left[i] * right[i];
            res %= 1_000_000_007;
        }
        res
    }
}