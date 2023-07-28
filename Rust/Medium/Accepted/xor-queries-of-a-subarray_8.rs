impl Solution {
    pub fn xor_queries(arr: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = Vec::new();
        let mut xor_arr = Vec::new();
        let mut xor = 0;
        for i in 0..arr.len() {
            xor ^= arr[i];
            xor_arr.push(xor);
        }
        for i in 0..queries.len() {
            let left = queries[i][0] as usize;
            let right = queries[i][1] as usize;
            if left == 0 {
                result.push(xor_arr[right]);
            } else {
                result.push(xor_arr[right] ^ xor_arr[left - 1]);
            }
        }
        result
    }
}