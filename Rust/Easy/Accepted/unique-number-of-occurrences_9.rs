impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for i in arr {
            map.entry(i).and_modify(|x| *x += 1).or_insert(1);
        }
        let mut map2 = std::collections::HashMap::new();
        for i in map.values() {
            map2.entry(i).and_modify(|x| *x += 1).or_insert(1);
        }
        map2.values().all(|x| *x == 1)
    }
}