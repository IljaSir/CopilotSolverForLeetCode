impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        let mut start = 0;
        for i in 0..fruits.len() {
            let count = map.entry(fruits[i]).or_insert(0);
            *count += 1;
            while map.len() > 2 {
                let count = map.get_mut(&fruits[start]).unwrap();
                *count -= 1;
                if *count == 0 {
                    map.remove(&fruits[start]);
                }
                start += 1;
            }
            max = max.max(i - start + 1);
        }
        max as i32
    }
}