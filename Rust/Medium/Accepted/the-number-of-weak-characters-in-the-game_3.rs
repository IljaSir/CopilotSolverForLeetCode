impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut properties = properties;
        properties.sort_by(|a, b| b[0].cmp(&a[0]).then(a[1].cmp(&b[1])));
        let mut max = 0;
        let mut res = 0;
        for i in 0..properties.len() {
            if properties[i][1] < max {
                res += 1;
            } else {
                max = max.max(properties[i][1]);
            }
        }
        res
    }
}