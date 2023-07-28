impl Solution {
    pub fn min_operations(target: Vec<i32>, arr: Vec<i32>) -> i32 {
        
        let mut pos = vec![0; 100001];
        for (i, &x) in target.iter().enumerate() {
            pos[x as usize] = i + 1;
        }
        let mut dp = vec![0; target.len() + 1];
        let mut len = 0;
        for &x in arr.iter() {
            if pos[x as usize] > 0 {
                let mut l = 0;
                let mut r = len;
                while l < r {
                    let mid = (l + r + 1) / 2;
                    if dp[mid] < pos[x as usize] {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                len = len.max(l + 1);
                dp[l + 1] = pos[x as usize];
            }
        }
        target.len() as i32 - len
    }
}