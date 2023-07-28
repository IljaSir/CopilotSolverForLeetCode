impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut start = 0;
        let mut max = 0;
        for (i, &fruit) in fruits.iter().enumerate() {
            *map.entry(fruit).or_insert(0) += 1;
            while map.len() > 2 {
                if let Some(&mut count) = map.get_mut(&fruits[start]) {
                    if count == 1 {
                        map.remove(&fruits[start]);
                    } else {
                        count -= 1;
                    }
                }
                start += 1;
            }
            max = max.max(i - start + 1);
        }
        max as i32
    }
}