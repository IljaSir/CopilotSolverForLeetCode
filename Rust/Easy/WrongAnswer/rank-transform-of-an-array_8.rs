impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort();
        let mut map = std::collections::HashMap::new();
        let mut r = 1;
        for n in arr.iter() {
            if !map.contains_key(n) {
                map.insert(n, r);
                r += 1;
            }
        }
        arr.iter().map(|n| map[n]).collect()
    }
}