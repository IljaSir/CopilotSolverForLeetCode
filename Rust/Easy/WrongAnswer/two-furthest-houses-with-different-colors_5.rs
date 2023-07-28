impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut left = vec![0; colors.len()];
        let mut right = vec![0; colors.len()];
        let mut l = 0;
        let mut r = 0;
        for i in 0..colors.len() {
            if colors[i] == colors[0] {
                l += 1;
            }
            left[i] = l;
            let j = colors.len() - i - 1;
            if colors[j] == colors[colors.len() - 1] {
                r += 1;
            }
            right[j] = r;
        }
        let mut max = 0;
        for i in 0..colors.len() {
            if colors[i] != colors[0] {
                max = max.max(i - left[i]);
            }
            if colors[i] != colors[colors.len() - 1] {
                max = max.max(right[i] - i);
            }
        }
        max as i32
    }
}