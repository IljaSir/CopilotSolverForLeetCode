impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut left: Vec<i32> = Vec::new();
        let mut right: Vec<i32> = Vec::new();
        let mut res: i32 = 0;
        let mut modu = 1000000007;
        for i in 0..arr.len() {
            let mut count = 1;
            while !stack.is_empty() && stack[stack.len() - 1] > arr[i] {
                stack.pop();
                count += left.pop().unwrap();
            }
            left.push(count);
            stack.push(arr[i]);
        }
        stack.clear();
        for i in (0..arr.len()).rev() {
            let mut count = 1;
            while !stack.is_empty() && stack[stack.len() - 1] >= arr[i] {
                stack.pop();
                count += right.pop().unwrap();
            }
            right.push(count);
            stack.push(arr[i]);
        }
        for i in 0..arr.len() {
            res = (res + arr[i] * left[i] * right[arr.len() - 1 - i]) % modu;
        }
        res
    }
}