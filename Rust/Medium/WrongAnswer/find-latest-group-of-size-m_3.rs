impl Solution {
    pub fn find_latest_step(arr: Vec<i32>, m: i32) -> i32 {
        
        let n = arr.len();
        let mut v = vec![0; n + 2];
        let mut ans = -1;
        for (i, &x) in arr.iter().enumerate() {
            let l = v[(x - 1) as usize];
            let r = v[(x + 1) as usize];
            if l == m || r == m {
                ans = i as i32;
            }
            v[(x - l) as usize] = l + r + 1;
            v[(x + r) as usize] = l + r + 1;
        }
        ans
    }
}