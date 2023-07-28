impl Solution {
    pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
        
        let mut properties = properties;
        properties.sort_by(|a, b| {
            if a[0] == b[0] {
                b[1].cmp(&a[1])
            } else {
                a[0].cmp(&b[0])
            }
        });
        let mut max = 0;
        let mut weak = 0;
        for i in 0..properties.len() {
            if properties[i][1] < max {
                weak += 1;
            } else {
                max = max.max(properties[i][1]);
            }
        }
        weak
    }
}