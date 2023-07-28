impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack = vec![];
        let mut left = vec![0; arr.len()];
        let mut right = vec![0; arr.len()];
        let mut res = 0;
        let modu = 1000000007;
        for i in 0..arr.len() {
            let mut count = 1;
            while !stack.is_empty() && stack.last().unwrap().0 >= arr[i] {
                count += stack.pop().unwrap().1;
            }
            left[i] = count;
            stack.push((arr[i], count));
        }
        stack.clear();
        for i in (0..arr.len()).rev() {
            let mut count = 1;
            while !stack.is_empty() && stack.last().unwrap().0 > arr[i] {
                count += stack.pop().unwrap().1;
            }
            right[i] = count;
            stack.push((arr[i], count));
        }
        for i in 0..arr.len() {
            res = (res + arr[i] * left[i] * right[i]) % modu;
        }
        res
    }
}