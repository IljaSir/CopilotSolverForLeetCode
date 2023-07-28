impl Solution {
    pub fn find_latest_step(arr: Vec<i32>, m: i32) -> i32 {
        
        let n = arr.len();
        let mut left = vec![0; n + 2];
        let mut right = vec![0; n + 2];
        let mut ans = -1;
        for (i, &x) in arr.iter().enumerate() {
            let x = x as usize;
            let l = left[x - 1];
            let r = right[x + 1];
            if l == m || r == m {
                ans = i as i32;
            }
            left[x + r] = l + r + 1;
            right[x - l] = l + r + 1;
        }
        ans
    }
}