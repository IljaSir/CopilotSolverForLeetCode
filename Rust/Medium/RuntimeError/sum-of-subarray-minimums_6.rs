impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack = Vec::new();
        let mut left = Vec::new();
        let mut right = Vec::new();
        let n = arr.len();
        let mut i = 0;
        while i < n {
            while !stack.is_empty() && arr[stack[stack.len() - 1] as usize] >= arr[i] {
                stack.pop();
            }
            if stack.is_empty() {
                left.push(-1);
            } else {
                left.push(stack[stack.len() - 1]);
            }
            stack.push(i as i32);
            i += 1;
        }
        stack.clear();
        i = n - 1;
        while i >= 0 {
            while !stack.is_empty() && arr[stack[stack.len() - 1] as usize] > arr[i] {
                stack.pop();
            }
            if stack.is_empty() {
                right.push(n as i32);
            } else {
                right.push(stack[stack.len() - 1]);
            }
            stack.push(i as i32);
            i -= 1;
        }
        right.reverse();
        let mut sum = 0;
        let modu = 1000000007;
        for i in 0..n {
            sum += arr[i] * ((right[i] - i as i32) * (i as i32 - left[i])) % modu;
        }
        sum as i32
    }
}