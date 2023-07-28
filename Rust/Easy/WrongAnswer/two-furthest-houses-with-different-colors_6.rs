impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        
        let mut left = vec![0; colors.len()];
        let mut right = vec![0; colors.len()];
        let mut left_max = 0;
        let mut right_max = 0;
        for i in 0..colors.len() {
            left[i] = left_max;
            if colors[i] > colors[left_max] {
                left_max = i;
            }
        }
        for i in (0..colors.len()).rev() {
            right[i] = right_max;
            if colors[i] > colors[right_max] {
                right_max = i;
            }
        }
        let mut max = 0;
        for i in 0..colors.len() {
            if colors[i] != colors[left[i]] {
                max = max.max(i - left[i]);
            }
            if colors[i] != colors[right[i]] {
                max = max.max(right[i] - i);
            }
        }
        max as i32
    }
}