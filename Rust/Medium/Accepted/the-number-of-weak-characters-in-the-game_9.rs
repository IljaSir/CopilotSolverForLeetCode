impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut props = properties;
        props.sort_by_key(|x| (x[0], -x[1]));
        let mut max_def = 0;
        let mut ans = 0;
        for i in (0..props.len()).rev() {
            if props[i][1] < max_def {
                ans += 1;
            } else {
                max_def = props[i][1];
            }
        }
        ans
    }
}