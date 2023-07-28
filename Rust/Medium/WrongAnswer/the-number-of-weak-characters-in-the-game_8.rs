impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut properties = properties;
        properties.sort_by_key(|v| (v[0], -v[1]));
        let mut max = 0;
        let mut ans = 0;
        for v in properties.iter() {
            if v[1] < max {
                ans += 1;
            } else {
                max = v[1];
            }
        }
        ans
    }
}