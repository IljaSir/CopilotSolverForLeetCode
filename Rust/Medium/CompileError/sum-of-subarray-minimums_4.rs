impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut result = 0;
        let mut stack = Vec::new();
        for i in 0..arr.len() {
            while !stack.is_empty() && arr[stack[stack.len() - 1]] > arr[i] {
                let index = stack.pop().unwrap();
                let left = if stack.is_empty() { -1 } else { stack[stack.len() - 1] };
                result += (index - left) as i32 * arr[index] * (i as i32 - index as i32);
                result %= 1000000007;
            }
            stack.push(i);
        }
        while !stack.is_empty() {
            let index = stack.pop().unwrap();
            let left = if stack.is_empty() { -1 } else { stack[stack.len() - 1] };
            result += (index - left) as i32 * arr[index] * (arr.len() as i32 - index as i32);
            result %= 1000000007;
        }
        result
    }
}