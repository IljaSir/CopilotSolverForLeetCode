impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for c in text.chars() {
            *map.entry(c).or_insert(0) += 1;
        }
        let mut count = 0;
        loop {
            if map.get(&'b').unwrap_or(&0) == &0 {
                break;
            }
            if map.get(&'a').unwrap_or(&0) == &0 {
                break;
            }
            if map.get(&'l').unwrap_or(&0) < &2 {
                break;
            }
            if map.get(&'o').unwrap_or(&0) < &2 {
                break;
            }
            if map.get(&'n').unwrap_or(&0) == &0 {
                break;
            }
            map.entry('b').and_modify(|e| *e -= 1);
            map.entry('a').and_modify(|e| *e -= 1);
            map.entry('l').and_modify(|e| *e -= 2);
            map.entry('o').and_modify(|e| *e -= 2);
            map.entry('n').and_modify(|e| *e -= 1);
            count += 1;
        }
        count
    }
}