impl Solution {
    pub fn find_latest_step(arr: Vec<i32>, m: i32) -> i32 {
        
        let n = arr.len();
        if n == m {
            return n as i32;
        }
        let mut left = vec![0; n + 2];
        let mut right = vec![0; n + 2];
        let mut res = -1;
        for (i, &x) in arr.iter().enumerate() {
            let x = x as usize;
            left[x] = x - left[x - 1];
            right[x] = right[x + 1] + x;
            if left[x] == m as usize || right[x] == m as usize {
                res = i as i32;
            }
            left[right[x]] = left[x];
            right[left[x]] = right[x];
        }
        res
    }
}