impl Solution {
    pub fn has_groups_size_x(deck: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in deck {
            let count = map.entry(i).or_insert(0);
            *count += 1;
        }
        let mut min = 10000;
        for (_, v) in map {
            if v < min {
                min = v;
            }
        }
        if min == 1 {
            return false;
        }
        for i in 2..min + 1 {
            let mut flag = true;
            for (_, v) in &map {
                if v % i != 0 {
                    flag = false;
                    break;
                }
            }
            if flag {
                return true;
            }
        }
        false
    }
}