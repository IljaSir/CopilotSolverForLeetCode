impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut properties = properties;
        properties.sort_by(|a, b| b[0].cmp(&a[0]).then(a[1].cmp(&b[1])));
        let mut max_def = 0;
        let mut ans = 0;
        for p in properties {
            if p[1] < max_def {
                ans += 1;
            } else {
                max_def = p[1];
            }
        }
        ans
    }
}