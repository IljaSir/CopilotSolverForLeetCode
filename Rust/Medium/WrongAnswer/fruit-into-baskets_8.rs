impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        let mut max = 0;
        let mut count = 0;
        let mut last = 0;
        let mut last_num = 0;
        let mut map = std::collections::HashMap::new();
        while right < fruits.len() {
            let n = fruits[right];
            let c = map.entry(n).or_insert(0);
            *c += 1;
            if n != last {
                last = n;
                last_num = 1;
            } else {
                last_num += 1;
            }
            right += 1;
            while map.len() > 2 {
                let n = fruits[left];
                let c = map.entry(n).or_insert(0);
                *c -= 1;
                if *c == 0 {
                    map.remove(&n);
                }
                left += 1;
            }
            if map.len() == 2 {
                count = map[&last] + map[&fruits[left]];
            } else if map.len() == 1 {
                count = map[&last];
            } else {
                count = 0;
            }
            if count > max {
                max = count;
            }
        }
        max as i32
    }
}