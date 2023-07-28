impl Solution {
    pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut result: i32 = 0;
        let mut sum: i32 = 0;
        let mut i: i32 = 0;
        let mut j: i32 = 0;
        let mut k: i32 = 0;
        let mut size: i32 = arr.len() as i32;
        let mut mod_value: i32 = 1000000007;
        let mut temp: i32 = 0;
        for i in 0..size {
            let mut count: i32 = 0;
            while !stack.is_empty() && arr[stack[stack.len() - 1] as usize] > arr[i as usize] {
                let mut top: i32 = stack.pop().unwrap();
                count += 1;
                temp = (temp + arr[top as usize] * (count * (i - top) + (top - k))) % mod_value;
            }
            k = i - count;
            stack.push(i);
            sum = (sum + temp) % mod_value;
        }
        sum
    }
}