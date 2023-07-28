impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack: Vec<(i32, usize)> = Vec::new();
        let mut sum = 0;
        let mut count = 0;
        for (i, v) in arr.iter().enumerate() {
            let mut c = 1;
            while let Some((u, j)) = stack.pop() {
                if u > *v {
                    c += count;
                    count = 0;
                    stack.push((u, j));
                    break;
                }
                count += j + 1;
            }
            stack.push((*v, c));
            sum += *v * c;
        }
        (sum % 1000000007) as i32
    }
}