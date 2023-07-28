impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let n = colors.len();
        let mut left = vec![0; n];
        let mut right = vec![0; n];
        let mut last = vec![0; 101];
        for i in 0..n {
            last[colors[i] as usize] = i;
            left[i] = last[colors[i] as usize];
        }
        last = vec![n; 101];
        for i in (0..n).rev() {
            last[colors[i] as usize] = i;
            right[i] = last[colors[i] as usize];
        }
        let mut ans = 0;
        for i in 0..n {
            ans = ans.max((left[i] as i32 - i as i32).abs());
            ans = ans.max((right[i] as i32 - i as i32).abs());
        }
        ans
    }
}