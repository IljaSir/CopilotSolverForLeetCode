impl Solution {
    pub fn find_latest_step(arr: Vec<i32>, m: i32) -> i32 {
        
        let mut n = arr.len();
        let mut f = vec![0; n + 2];
        let mut ans = -1;
        for i in 0..n {
            let x = arr[i] as usize;
            let left = f[x - 1];
            let right = f[x + 1];
            if left == m || right == m {
                ans = i as i32;
            }
            f[x - left] = left + right + 1;
            f[x + right] = left + right + 1;
        }
        ans
    }
}