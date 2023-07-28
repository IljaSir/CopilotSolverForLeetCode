impl Solution {
    pub fn maximum_groups(grades: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut sum = 0;
        let mut g = grades;
        g.sort();
        for i in 0..g.len() {
            sum += g[i];
            if sum < (i+1) as i32 * g[i] {
                count += 1;
            }
        }
        count
    }
}