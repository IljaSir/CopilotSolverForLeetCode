impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut map = std::collections::HashMap::new();
        let mut start = 0;
        for (i, &fruit) in fruits.iter().enumerate() {
            *map.entry(fruit).or_insert(0) += 1;
            while map.len() > 2 {
                let start_fruit = fruits[start];
                if let Some(count) = map.get_mut(&start_fruit) {
                    *count -= 1;
                    if *count == 0 {
                        map.remove(&start_fruit);
                    }
                }
                start += 1;
            }
            max = max.max(i - start + 1);
        }
        max as i32
    }
}