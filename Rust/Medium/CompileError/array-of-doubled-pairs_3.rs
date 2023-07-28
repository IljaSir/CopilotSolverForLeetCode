impl Solution {
    pub fn can_reorder_doubled(arr: Vec<i32>) -> bool {
        
        let mut arr = arr;
        arr.sort_unstable();
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for x in arr {
            *map.entry(x).or_insert(0) += 1;
        }
        for x in arr {
            if map[&x] == 0 {
                continue;
            }
            let y = if x < 0 && x % 2 == 0 {
                x / 2
            } else {
                x * 2
            };
            if map[&x] > map[&y] {
                return false;
            }
            map.entry(y).and_modify(|e| *e -= map[&x]);
        }
        true
    }
}