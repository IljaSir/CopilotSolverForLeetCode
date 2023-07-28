impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut properties = properties;
        properties.sort_by(|a, b| a[0].cmp(&b[0]).reverse());
        let mut max = 0;
        let mut count = 0;
        for i in 0..properties.len() {
            if properties[i][1] < max {
                count += 1;
            } else {
                max = max.max(properties[i][1]);
            }
        }
        count
    }
}