impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        while right < fruits.len() {
            *map.entry(fruits[right]).or_insert(0) += 1;
            if map.get(&fruits[right]).unwrap() == &1 {
                count += 1;
            }
            right += 1;
            while count > 2 {
                *map.get_mut(&fruits[left]).unwrap() -= 1;
                if map.get(&fruits[left]).unwrap() == &0 {
                    count -= 1;
                }
                left += 1;
            }
            max = max.max(right - left);
        }
        max as i32
    }
}