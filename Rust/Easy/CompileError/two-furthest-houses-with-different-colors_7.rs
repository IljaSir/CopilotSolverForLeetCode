impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut left = vec![0; colors.len()];
        let mut right = vec![0; colors.len()];
        let mut cl = colors[0];
        let mut cr = colors[colors.len() - 1];
        for i in 1..colors.len() {
            if cl == colors[i] {
                left[i] = left[i - 1];
            } else {
                left[i] = i;
                cl = colors[i];
            }
        }
        for i in (0..colors.len() - 1).rev() {
            if cr == colors[i] {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
                cr = colors[i];
            }
        }
        let mut max = 0;
        for i in 0..colors.len() {
            let d = (left[i] - i).abs();
            if d > max {
                max = d;
            }
            let d = (right[i] - i).abs();
            if d > max {
                max = d;
            }
        }
        max as i32
    }
}