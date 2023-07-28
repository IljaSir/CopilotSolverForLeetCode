impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut left = vec![0; arr.len()];
        let mut right = vec![0; arr.len()];
        let mut i = 0;
        while i < arr.len() {
            while !stack.is_empty() && arr[*stack.last().unwrap()] > arr[i] {
                stack.pop();
            }
            left[i] = if stack.is_empty() { i + 1 } else { i - *stack.last().unwrap() };
            stack.push(i);
            i += 1;
        }
        stack.clear();
        i = arr.len();
        while i > 0 {
            i -= 1;
            while !stack.is_empty() && arr[*stack.last().unwrap()] >= arr[i] {
                stack.pop();
            }
            right[i] = if stack.is_empty() { arr.len() - i } else { *stack.last().unwrap() - i };
            stack.push(i);
        }
        let mut sum = 0;
        for i in 0..arr.len() {
            sum += arr[i] as i64 * left[i] as i64 * right[i] as i64;
            sum %= 1000000007;
        }
        sum as i32
    }
}